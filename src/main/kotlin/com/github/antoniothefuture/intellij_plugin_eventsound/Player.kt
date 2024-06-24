package com.github.antoniothefuture.intellij_plugin_eventsound

import com.intellij.openapi.diagnostic.thisLogger
import java.io.File
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.FloatControl
import javax.sound.sampled.LineEvent
import kotlin.math.log10


class Player {
    var playerStopListener: PlayerStopListener? = null
    var playing: Boolean = false

    fun setOnStopListener(playerStopListener: PlayerStopListener) {
        this.playerStopListener = playerStopListener
    }

    fun play(filePath: String) {
        try {
            val volume = 1.0
            val clip = AudioSystem.getClip()
            val audioInputStream = AudioSystem.getAudioInputStream(File(filePath))
            clip.open(audioInputStream)
            val floatControl = clip.getControl(FloatControl.Type.MASTER_GAIN) as FloatControl
            floatControl.value = log10(volume).toFloat() * 20
            clip.addLineListener { event: LineEvent? ->
                if (event != null) {
                    if (event.type == LineEvent.Type.STOP) {
                        playerStopListener?.stop()
                        playing = false
                        clip.close()
                    }
                }
            }
            playing = true
            clip.start()
        } catch (e: Exception) {
            thisLogger().error(e.localizedMessage)
        }
    }
}

interface PlayerStopListener {
    fun stop() {}
}