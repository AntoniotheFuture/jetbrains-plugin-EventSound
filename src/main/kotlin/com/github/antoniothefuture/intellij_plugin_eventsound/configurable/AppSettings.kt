package com.github.antoniothefuture.intellij_plugin_eventsound.configurable

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import org.jetbrains.annotations.NonNls


@State(name = "org.intellij.sdk.settings.AppSettings", storages = [Storage("SdkSettingsPlugin.xml")])
internal class AppSettings

    : PersistentStateComponent<AppSettings.State> {
    internal class State {
        var userId: @NonNls String? = "John Smith"
        var ideaStatus: Boolean = false
    }

    private var myState = State()

    override fun getState(): State {
        return myState
    }

    override fun loadState(state: State) {
        myState = state
    }

    companion object {
        val instance: AppSettings
            get() = ApplicationManager.getApplication()
                .getService(AppSettings::class.java)
    }
}