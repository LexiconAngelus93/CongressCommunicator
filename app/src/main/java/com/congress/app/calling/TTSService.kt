package com.congress.app.calling

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.*
import kotlin.coroutines.resume

/**
 * Text-to-Speech service with natural voice synthesis for call scripts
 */
class TTSService(private val context: Context) {
    
    companion object {
        private const val TAG = "TTSService"
    }
    
    private var tts: TextToSpeech? = null
    private var isInitialized = false
    private var currentUtteranceId = 0
    
    data class TTSConfig(
        val speechRate: Float = 0.8f,  // Slightly slower for clarity
        val pitch: Float = 1.0f,
        val language: Locale = Locale.US,
        val voice: String? = null
    )
    
    /**
     * Initialize TTS engine
     */
    suspend fun initialize(): Boolean = suspendCancellableCoroutine { continuation ->
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                isInitialized = true
                setupTTS()
                Log.i(TAG, "TTS initialized successfully")
                continuation.resume(true)
            } else {
                Log.e(TAG, "TTS initialization failed")
                continuation.resume(false)
            }
        }
    }
    
    /**
     * Configure TTS with natural voice settings
     */
    private fun setupTTS() {
        tts?.let { engine ->
            // Set language
            val result = engine.setLanguage(Locale.US)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.w(TAG, "Language not supported")
            }
            
            // Configure for natural speech
            engine.setSpeechRate(0.8f)  // Slightly slower for clarity
            engine.setPitch(1.0f)       // Normal pitch
            
            // Try to use a more natural voice if available
            val voices = engine.voices
            val naturalVoice = voices?.find { voice ->
                voice.locale == Locale.US && 
                (voice.name.contains("enhanced", true) || 
                 voice.name.contains("neural", true) ||
                 voice.name.contains("premium", true))
            }
            
            if (naturalVoice != null) {
                engine.voice = naturalVoice
                Log.i(TAG, "Using enhanced voice: ${naturalVoice.name}")
            } else {
                Log.i(TAG, "Using default voice")
            }
        }
    }
    
    /**
     * Speak text with natural voice
     */
    suspend fun speak(text: String, config: TTSConfig = TTSConfig()): Boolean = 
        suspendCancellableCoroutine { continuation ->
            if (!isInitialized) {
                Log.e(TAG, "TTS not initialized")
                continuation.resume(false)
                return@suspendCancellableCoroutine
            }
            
            val utteranceId = "utterance_${++currentUtteranceId}"
            
            // Apply configuration
            tts?.setSpeechRate(config.speechRate)
            tts?.setPitch(config.pitch)
            
            // Set up progress listener
            tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                override fun onStart(utteranceId: String?) {
                    Log.d(TAG, "TTS started: $utteranceId")
                }
                
                override fun onDone(utteranceId: String?) {
                    Log.d(TAG, "TTS completed: $utteranceId")
                    continuation.resume(true)
                }
                
                override fun onError(utteranceId: String?) {
                    Log.e(TAG, "TTS error: $utteranceId")
                    continuation.resume(false)
                }
            })
            
            // Speak the text
            val result = tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId)
            if (result != TextToSpeech.SUCCESS) {
                Log.e(TAG, "Failed to start TTS")
                continuation.resume(false)
            }
        }
    
    /**
     * Speak call script with pauses and natural pacing
     */
    suspend fun speakScript(script: String, config: TTSConfig = TTSConfig()): Boolean {
        if (!isInitialized) return false
        
        // Split script into sentences for natural pacing
        val sentences = script.split(Regex("[.!?]+")).filter { it.trim().isNotEmpty() }
        
        for (sentence in sentences) {
            val trimmedSentence = sentence.trim()
            if (trimmedSentence.isNotEmpty()) {
                val success = speak(trimmedSentence, config)
                if (!success) return false
                
                // Add natural pause between sentences
                Thread.sleep(500)
            }
        }
        
        return true
    }
    
    /**
     * Stop current speech
     */
    fun stop() {
        tts?.stop()
    }
    
    /**
     * Check if TTS is speaking
     */
    fun isSpeaking(): Boolean {
        return tts?.isSpeaking ?: false
    }
    
    /**
     * Get available voices
     */
    fun getAvailableVoices(): List<String> {
        return tts?.voices?.map { it.name } ?: emptyList()
    }
    
    /**
     * Set specific voice by name
     */
    fun setVoice(voiceName: String): Boolean {
        val voice = tts?.voices?.find { it.name == voiceName }
        return if (voice != null) {
            tts?.voice = voice
            true
        } else {
            false
        }
    }
    
    /**
     * Generate SSML for more natural speech
     */
    fun generateSSML(text: String, pauseMs: Int = 500): String {
        return """
            <speak>
                <prosody rate="0.8" pitch="1.0">
                    ${text.replace(".", ".<break time=\"${pauseMs}ms\"/>")
                           .replace("!", "!<break time=\"${pauseMs}ms\"/>")
                           .replace("?", "?<break time=\"${pauseMs}ms\"/>")}
                </prosody>
            </speak>
        """.trimIndent()
    }
    
    /**
     * Speak with SSML for enhanced naturalness
     */
    suspend fun speakWithSSML(ssml: String): Boolean = suspendCancellableCoroutine { continuation ->
        if (!isInitialized) {
            continuation.resume(false)
            return@suspendCancellableCoroutine
        }
        
        val utteranceId = "ssml_${++currentUtteranceId}"
        
        tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) {}
            override fun onDone(utteranceId: String?) { continuation.resume(true) }
            override fun onError(utteranceId: String?) { continuation.resume(false) }
        })
        
        // Note: SSML support varies by TTS engine
        val result = tts?.speak(ssml, TextToSpeech.QUEUE_FLUSH, null, utteranceId)
        if (result != TextToSpeech.SUCCESS) {
            continuation.resume(false)
        }
    }
    
    /**
     * Release TTS resources
     */
    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
        tts = null
        isInitialized = false
    }
}

