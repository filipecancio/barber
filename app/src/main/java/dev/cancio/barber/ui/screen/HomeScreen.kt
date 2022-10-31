package dev.cancio.barber.ui.screen

import android.text.style.ClickableSpan
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            modifier = Modifier
                .align(Alignment.Center),
            onClick = { /*TODO*/ }
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