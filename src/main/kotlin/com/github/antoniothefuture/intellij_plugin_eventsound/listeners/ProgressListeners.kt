package com.github.antoniothefuture.intellij_plugin_eventsound.listeners

import com.github.antoniothefuture.intellij_plugin_eventsound.services.MyAppServiceImpl
import com.intellij.openapi.components.service
import com.intellij.openapi.progress.ProgressManagerListener
import com.intellij.openapi.progress.Task


internal class ESProgressManagerListener: ProgressManagerListener {
    override fun afterTaskFinished(task: Task) {
        super.afterTaskFinished(task)
        service<MyAppServiceImpl>().progressFinished(task.title)
    }
}