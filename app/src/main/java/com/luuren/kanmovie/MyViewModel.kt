package com.luuren.kanmovie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * doc
 * create by Luuren on 2019/12/27 11:27
 */
class MyViewModel : ViewModel() {

    // Create a LiveData with a String
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getName() {
        viewModelScope.launch {
            currentName.postValue( doSomething())
        }
    }

    private suspend fun doSomething(): String = withContext(Dispatchers.IO) {
        delay(5000)
        return@withContext "uuu"
    }
}