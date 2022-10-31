package dev.cancio.barber.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(){
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