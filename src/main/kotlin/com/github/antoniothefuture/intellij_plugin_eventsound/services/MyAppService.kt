package com.github.antoniothefuture.intellij_plugin_eventsound.services

interface MyAppService {
    fun eventTriggered(eventTypeAndStatus: String)

    fun notificationShown(title: String, content: String)

    fun progressFinished(title: String)
}