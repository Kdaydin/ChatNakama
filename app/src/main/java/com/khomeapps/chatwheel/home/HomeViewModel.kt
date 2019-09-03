package com.khomeapps.chatwheel.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

/**
 * Created by kubilaay on 2019-05-18.
 */
class HomeViewModel : ViewModel() {
    var mTest: MutableLiveData<String> = MutableLiveData()
    val welcomeText = "W E L C O M E"
    fun searchNewMatch() {
        mTest.value = Random(6).nextInt().toString()
    }
}