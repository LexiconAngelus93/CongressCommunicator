package com.congress.app.calling

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.*
import kotlin.coroutines.resume

/**
 * Text-to-Speech service using Android's built-in TTS engine
 */
class TTSService(private val context: Context) {
    
    companion object {
        private const val TAG = "TTSService"
    }
    
    private var tts: TextToSpeech? = null
    private var isInitialized = false
    
    /**
     * Initialize the TTS engine
     */
    suspend fun initialize(): Boolean = suspendCancellableCoroutine { continuation ->
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val result = tts?.setLanguage(Locale.US)
                isInitialized = result != TextToSpeech.LANG_MISSING_DATA && 
                               result != TextToSpeech.LANG_NOT_SUPPORTED
                
                if (isInitialized) {
                    // Configure TTS for natural speech
                    tts?.setSpeechRate(0.9f) // Slightly slower for clarity
                    tts?.setPitch(1.0f) // Normal pitch
                    Log.i(TAG, "TTS initialized successfully")
                } else {
                    Log.e(TAG, "TTS language not supported")
                }
                continuation.resume(isInitialized)
            } else {
                Log.e(TAG, "TTS initialization failed")
                continuation.resume(false)
            }
        }
    }
    
    /**
     * Speak text with natural voice
     */
    suspend fun speak(text: String, utteranceId: String = "default"): Boolean {
        if (!isInitialized) {
            Log.w(TAG, "TTS not initialized")
            return false
        }
        
        return suspendCancellableCoroutine { continuation ->
            tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                override fun onStart(utteranceId: String?) {
                    Log.d(TAG, "TTS started speaking: $utteranceId")
                }
                
                override fun onDone(utteranceId: String?) {
                    Log.d(TAG, "TTS finished speaking: $utteranceId")
                    continuation.resume(true)
                }
                
                override fun onError(utteranceId: String?) {
                    Log.e(TAG, "TTS error: $utteranceId")
                    continuation.resume(false)
                }
            })
            
            val result = tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId)
            if (result != TextToSpeech.SUCCESS) {
                Log.e(TAG, "Failed to start TTS")
                continuation.resume(false)
            }
        }
    }
    
    /**
     * Read a script with natural pauses
     */
    suspend fun readScript(script: String): Boolean {
        if (!isInitialized) {
            return false
        }
        
        // Split script into sentences for natural pauses
        val sentences = script.split(Regex("[.!?]+")).filter { it.trim().isNotEmpty() }
        
        for ((index, sentence) in sentences.withIndex()) {
            val success = speak(sentence.trim(), "sentence_$index")
            if (!success) {
                return false
            }
            
            // Add natural pause between sentences
            kotlinx.coroutines.delay(500)
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
     * Set speech rate (0.5 to 2.0)
     */
    fun setSpeechRate(rate: Float) {
        tts?.setSpeechRate(rate.coerceIn(0.5f, 2.0f))
    }
    
    /**
     * Set pitch (0.5 to 2.0)
     */
    fun setPitch(pitch: Float) {
        tts?.setPitch(pitch.coerceIn(0.5f, 2.0f))
    }
    
    /**
     * Get available voices
     */
    fun getAvailableVoices(): Set<android.speech.tts.Voice>? {
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            tts?.voices
        } else {
            null
        }
    }
    
    /**
     * Set voice (Android 5.0+)
     */
    fun setVoice(voice: android.speech.tts.Voice): Boolean {
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            tts?.setVoice(voice) == TextToSpeech.SUCCESS
        } else {
            false
        }
    }
    
    /**
     * Get preferred voice for natural speech
     */
    fun getPreferredVoice(): android.speech.tts.Voice? {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            val voices = getAvailableVoices()
            
            // Prefer high-quality English voices
            return voices?.find { voice ->
                voice.locale.language == "en" && 
                voice.quality >= android.speech.tts.Voice.QUALITY_HIGH &&
                !voice.isNetworkConnectionRequired
            } ?: voices?.find { voice ->
                voice.locale.language == "en" &&
                !voice.isNetworkConnectionRequired
            }
        }
        return null
    }
    
    /**
     * Configure for best quality speech
     */
    fun configureBestQuality() {
        getPreferredVoice()?.let { voice ->
            setVoice(voice)
            Log.i(TAG, "Set preferred voice: ${voice.name}")
        }
        
        // Set optimal speech parameters for clarity
        setSpeechRate(0.85f) // Slightly slower for better comprehension
        setPitch(1.0f) // Normal pitch
    }
    
    /**
     * Release TTS resources
     */
    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
        tts = null
        isInitialized = false
        Log.i(TAG, "TTS service shut down")
    }
}

