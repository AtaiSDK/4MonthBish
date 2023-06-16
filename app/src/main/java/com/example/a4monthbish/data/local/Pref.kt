package com.example.a4monthbish.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.media.MediaCodec.MetricsConstants.MODE

class Pref(private val context: Context) {

    private val pref by lazy {
        context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)

    }

    fun isUserSeen(): Boolean {
        return pref.getBoolean(SEEN_KEY, false)
    }
    fun saveSeen(){
        pref.edit().putBoolean(SEEN_KEY, true).apply()
    }
    fun saveName(name : String) {
        pref.edit().putString(NAME_KEY, name).apply()
    }
    fun getName() : String? {
        return pref.getString(NAME_KEY, null)
    }
    fun saveSurname(name : String) {
        pref.edit().putString(SURNAME_KEY, name).apply()
    }
    fun getSurName() : String? {
        return pref.getString(SURNAME_KEY, null)
    }

    companion object {
        const val PREF_NAME = "task.pref"
        const val SEEN_KEY = "user_key"
        const val NAME_KEY = "name_kay"
        const val SURNAME_KEY = "surname_kay"
    }


}