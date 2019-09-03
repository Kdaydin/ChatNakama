package com.khomeapps.chatwheel.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

/**
 * Created by kubilaay on 2019-05-18.
 */
class SplashViewModel : ViewModel() {
    private var auth = FirebaseAuth.getInstance()
    var mCurrUser: MutableLiveData<FirebaseUser> = MutableLiveData()

    fun logUserIn() {
        val currentUser = auth.currentUser
        if (currentUser == null) {
            auth.signInAnonymously().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    mCurrUser.value = auth.currentUser
                } else {
                    mCurrUser.value = null
                }
            }
        } else {
            mCurrUser.value = currentUser
        }
    }
}