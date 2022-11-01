package dev.cancio.barber.ui.screen

import android.content.Intent
import android.speech.SpeechRecognizer
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.cancio.barber.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    speechRecognizer: SpeechRecognizer,
    intent: Intent,
) {
    val viewModel = HomeViewModel(speechRecognizer,intent)
    val state = remember{ mutableStateOf(HearState.Not) }

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            modifier = Modifier
                .align(Alignment.Center),
            onClick = { state.value = viewModel.onClickButton(state.value) }
        ) {
            Text(text = viewModel.updateText(state.value))
        }
    }
}

enum class HearState(){
    Yes(),
    Not()
}