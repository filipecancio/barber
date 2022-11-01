package dev.cancio.barber.viewmodel

import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.SpeechRecognizer
import android.util.Log
import androidx.lifecycle.ViewModel
import dev.cancio.barber.ui.screen.HearState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HomeViewModel(
    val speechRecognizer: SpeechRecognizer,
    val intent: Intent,
): ViewModel() {

    fun onClickButton(state: HearState): HearState = when(state){
        HearState.Yes -> {
            speechRecognizer.startListening(intent)
            HearState.Yes
        }
        HearState.Not -> {
            speechRecognizer.stopListening()
            HearState.Not
        }
    }

    fun updateText(state: HearState) = when(state){
        HearState.Yes -> "Ouvindo"
        else -> "Aperte"
    }
}