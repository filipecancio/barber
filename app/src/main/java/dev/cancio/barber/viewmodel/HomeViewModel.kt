package dev.cancio.barber.viewmodel

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.SpeechRecognizer.*
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.cancio.barber.ui.screen.ViewState

class HomeViewModel(
    context: Context,
): ViewModel(), RecognitionListener {

    private var viewState: MutableLiveData<ViewState>? = null

    private val speechRecognizer: SpeechRecognizer = createSpeechRecognizer(context).apply {
        setRecognitionListener(this@HomeViewModel)
    }

    private val recognizerIntent: Intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
        putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true)
    }

    private val isListening
        get() = viewState?.value?.isListening ?: false

    var permissionToRecordAudio = checkAudioRecordingPermission(context)

    fun getViewState(): LiveData<ViewState> {
        if (viewState == null) {
            viewState = MutableLiveData()
            viewState?.value = initViewState()
        }

        return viewState as MutableLiveData<ViewState>
    }

    private fun initViewState() = ViewState(spokenText = "", isListening = false, error = null)

    fun startListening() {
        speechRecognizer.startListening(recognizerIntent)
        notifyListening(isRecording = true)
    }

    fun stopListening() {
        speechRecognizer.stopListening()
        notifyListening(isRecording = false)
    }

    private fun notifyListening(isRecording: Boolean) {
        viewState?.value = viewState?.value?.copy(isListening = isRecording)
    }

    private fun updateResults(speechBundle: Bundle?) {
        val userSaid = speechBundle?.getStringArrayList(RESULTS_RECOGNITION)
        viewState?.value = viewState?.value?.copy(spokenText = userSaid?.get(0) ?: "")
    }

    fun onClickButton() = if(isListening){
        stopListening()
    } else {
        startListening()
    }

    fun updateText() = if(isListening){
        "Ouvindo"
    } else {
        "Aperte"
    }

    private fun checkAudioRecordingPermission(context: Context) =
        ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED

    override fun onEndOfSpeech() = notifyListening(isRecording = false)

    override fun onError(errorCode: Int) {
        viewState?.value = viewState?.value?.copy(error = when (errorCode) {
            ERROR_AUDIO -> "error_audio_error"
            ERROR_CLIENT -> "error_client"
            ERROR_INSUFFICIENT_PERMISSIONS -> "error_permission"
            ERROR_NETWORK -> "error_network"
            ERROR_NETWORK_TIMEOUT -> "error_timeout"
            ERROR_NO_MATCH -> "error_no_match"
            ERROR_RECOGNIZER_BUSY -> "error_busy"
            ERROR_SERVER -> "error_server"
            ERROR_SPEECH_TIMEOUT -> "error_timeout"
            else -> "error_unknown"
        })
    }

    override fun onResults(results: Bundle?) = updateResults(speechBundle = results)

    override fun onPartialResults(results: Bundle?) = updateResults(speechBundle = results)

    override fun onReadyForSpeech(p0: Bundle?) {}
    override fun onRmsChanged(p0: Float) {}
    override fun onBufferReceived(p0: ByteArray?) {}
    override fun onEvent(p0: Int, p1: Bundle?) {}
    override fun onBeginningOfSpeech() {}
}