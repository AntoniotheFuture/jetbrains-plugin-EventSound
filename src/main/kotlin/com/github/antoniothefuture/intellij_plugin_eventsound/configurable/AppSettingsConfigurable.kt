package com.github.antoniothefuture.intellij_plugin_eventsound.configurable

import com.intellij.openapi.options.Configurable
import org.jetbrains.annotations.Nls
import java.util.*
import javax.swing.JComponent


/**
 * Provides controller functionality for application settings.
 */
internal class AppSettingsConfigurable : Configurable {
    private var mySettingsComponent: AppSettingsComponent? = null

    // A default constructor with no arguments is required because
    // this implementation is registered as an applicationConfigurable
    override fun getDisplayName(): @Nls(capitalization = Nls.Capitalization.Title) String? {
        return "SDK: Application Settings Example"
    }

    override fun getPreferredFocusedComponent(): JComponent? {
        return mySettingsComponent!!.preferredFocusedComponent
    }

    override fun createComponent(): JComponent? {
        mySettingsComponent = AppSettingsComponent()
        return mySettingsComponent!!.panel
    }

    override fun isModified(): Boolean {
        val state: AppSettings.State =
            Objects.requireNonNull(AppSettings.instance.state)
        return mySettingsComponent!!.userNameText != state.userId ||
                mySettingsComponent!!.ideaUserStatus != state.ideaStatus
    }

    override fun apply() {
        val state: AppSettings.State =
            Objects.requireNonNull(AppSettings.instance.state)
        state.userId = mySettingsComponent!!.userNameText
        state.ideaStatus = mySettingsComponent!!.ideaUserStatus
    }

    override fun reset() {
        val state: AppSettings.State =
            Objects.requireNonNull(AppSettings.instance.state)
        mySettingsComponent!!.userNameText = state.userId
        mySettingsComponent!!.ideaUserStatus = state.ideaStatus
    }

    override fun disposeUIResources() {
        mySettingsComponent = null
    }
}