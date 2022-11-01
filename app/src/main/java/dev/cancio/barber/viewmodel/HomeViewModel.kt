package dev.cancio.barber.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import dev.cancio.barber.ui.screen.HearState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HomeViewModel(): ViewModel() {

    fun onClickButton(scope: CoroutineScope): HearState{
        scope.launch {
            Log.e("Message","foi pivete")
        }
        return HearState.Yes
    }

    fun updateText(state: HearState) = when(state){
        HearState.Yes -> "Ouvindo"
        else -> "Aperte"
    }
}