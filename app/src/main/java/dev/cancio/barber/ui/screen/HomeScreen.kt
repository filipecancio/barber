package dev.cancio.barber.ui.screen

import android.content.Context
import android.content.Intent
import android.speech.SpeechRecognizer
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
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
    val text = remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyColumn(
            modifier = Modifier.align(Alignment.Center)
        ) {
            item { Text(text = text.value) }
            item {
                Button(
                    onClick = { text.value = viewModel.onClickButton() }
                ) {
                    Text(text = viewModel.updateText())
                }
            }
        }
    }
}