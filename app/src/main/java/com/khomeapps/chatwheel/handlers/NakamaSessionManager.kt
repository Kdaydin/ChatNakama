package com.khomeapps.chatwheel.handlers

import android.app.Activity
import android.content.Context
import com.heroiclabs.nakama.DefaultClient
import com.heroiclabs.nakama.DefaultSession
import com.heroiclabs.nakama.Session
import java.util.*


/**
 * Created by kubilaay on 2019-09-02.
 */
object NakamaSessionManager {
    val client = DefaultClient("defaultkey", "10.0.2.2", 7349,false)
    var session: Session? = null

    fun start(deviceId: String, activity: Activity) {
        val preferences = activity.getPreferences(Context.MODE_PRIVATE)
        // Lets check if we can restore a cached session.
        val sessionString = preferences.getString("nk.session", null)
        if (sessionString != null && sessionString.isNotEmpty()) {
            val restoredSession = DefaultSession.restore(sessionString)
            if (!restoredSession.isExpired(Date())) {
                // Session was valid and is restored now.
                this.session = restoredSession
                return
            }
        }
        this.session = client.authenticateCustom(deviceId).get()
        // Login was successful.
        // Store the session for later use.
        val pref = activity.getPreferences(Context.MODE_PRIVATE)
        pref.edit().putString("nk.session", session!!.authToken).apply()
        println(session!!.authToken)
    }
}