package dev.cancio.barber.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HomeViewModel(): ViewModel() {

    fun onClickButton(scope: CoroutineScope){
        scope.launch {

        }
    }
}