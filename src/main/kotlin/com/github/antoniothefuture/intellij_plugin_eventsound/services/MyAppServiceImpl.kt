package com.github.antoniothefuture.intellij_plugin_eventsound.services

import com.github.antoniothefuture.intellij_plugin_eventsound.Player
import com.github.antoniothefuture.intellij_plugin_eventsound.PlayerStopListener
import com.github.antoniothefuture.intellij_plugin_eventsound.config.EventRule
import com.github.antoniothefuture.intellij_plugin_eventsound.config.RegexRule
import com.intellij.openapi.components.Service

@Service
class MyAppServiceImpl: MyAppService {
    private var eventRules: List<EventRule> = listOf()
    private var notificationRules: List<RegexRule> = listOf()
    private var progressRules: List<RegexRule> = listOf()

    private var player: Player? = null

    private var playList: MutableList<String> = mutableListOf()
    private val maxPlaylist = 1

    init {
        // var rules: MutableList<EventRule> = mutableListOf()
        // rules.add(EventRule("Execution:processTerminated", "F:\\JavaProjects\\jetbrains-plugin-EventSound\\src\\main\\resources\\testSound\\tts (1).wav"))
        // rules.add(EventRule("Command:commandStarted", "F:\\JavaProjects\\jetbrains-plugin-EventSound\\src\\main\\resources\\testSound\\tts (1).wav"))
        // rules.add(EventRule("Branch:branchHasChanged", "F:\\JavaProjects\\jetbrains-plugin-EventSound\\src\\main\\resources\\testSound\\tts (1).wav"))
        // setEventRules(rules)
        // eventRules = rules
        // var rules2: MutableList<RegexRule> = mutableListOf()
        // rules2.add(RegexRule(Regex("Error running.*"), "F:\\下载\\tts (2).wav"))
        // notificationRules = rules2
        // var rules3: MutableList<RegexRule> = mutableListOf()
        // rules3.add(RegexRule(Regex("Loading history.*"), "F:\\下载\\tts (3).wav"))
        // progressRules = rules3
    }

    // Add sound file to playlist, if nothing is playing, it should start play
    private fun playSound(filePath: String) {
        if (player?.playing == true) {
            playList.add(filePath)
            if (playList.size > maxPlaylist) {
                playList = playList.drop(playList.size - maxPlaylist).toMutableList()
            }
            return
        }
        if (player === null) {
            player = Player()
            if (player!!.playerStopListener !== null) {
                player!!.setOnStopListener(object : PlayerStopListener {
                    override fun stop() {
                        super.stop()
                        playNext()
                    }
                })
            }
        }
        player!!.play(filePath)
    }

    fun playNext() {
        if (playList.isEmpty()) {
            return
        }
        playSound(playList[0])
        playList.removeFirst()
    }

    override fun eventTriggered(eventTypeAndStatus: String) {
        val matchRule = eventRules.find { it.eventTypeAndStatus === eventTypeAndStatus }
        if (matchRule !== null) {
            playSound(matchRule.soundFile)
        }
    }

    override fun notificationShown(title: String, content: String) {
        val matchRule = notificationRules.find { title.matches(it.regex) || content.matches(it.regex) }
        if (matchRule !== null) {
            playSound(matchRule.soundFile)
        }
    }

    override fun progressFinished(title: String) {
        val matchRule = progressRules.find { title.matches(it.regex) }
        if (matchRule !== null) {
            playSound(matchRule.soundFile)
        }
    }
}