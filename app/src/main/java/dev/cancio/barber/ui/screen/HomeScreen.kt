package dev.cancio.barber.ui.screen

import android.content.Context
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
import androidx.lifecycle.MutableLiveData
import dev.cancio.barber.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    context: Context,
) {

    val viewModel = HomeViewModel(context)

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            modifier = Modifier
                .align(Alignment.Center),
            onClick = { viewModel.onClickButton() }
        ) {
            Text(text = viewModel.updateText())
        }
    }
}