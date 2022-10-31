package dev.cancio.barber.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.cancio.barber.viewmodel.HomeViewModel

@Composable
fun HomeScreen() {
    val scope = rememberCoroutineScope()
    val viewModel = HomeViewModel()

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            modifier = Modifier
                .align(Alignment.Center),
            onClick = { viewModel.onClickButton(scope) }
        ) {
            Text(text = "Aperte")
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun RenderHomeScreen() = HomeScreen()