package com.github.antoniothefuture.intellij_plugin_eventsound.listeners

import com.github.antoniothefuture.intellij_plugin_eventsound.services.MyAppServiceImpl
import com.intellij.notification.Notification
import com.intellij.notification.Notifications
import com.intellij.openapi.components.service

internal class ESNotifications: Notifications {
    override fun notify(notification: Notification) {
        super.notify(notification)
        service<MyAppServiceImpl>().notificationShown(notification.title, notification.content)
    }
}
