package dev.cancio.barber.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HomeViewModel(): ViewModel() {

    fun onClickButton(scope: CoroutineScope){
        scope.launch {
            Log.e("Message","foi pivete")
        }
    }
}