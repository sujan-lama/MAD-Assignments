package com.miu.mdp.data

import android.content.SharedPreferences
import com.google.gson.Gson
import com.miu.mdp.constants.USERPREF
import com.miu.mdp.domain.model.UserDTO
import javax.inject.Inject

class SharedPreferenceHelper @Inject constructor(private val sharedPreferences: SharedPreferences) {

    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    var user: UserDTO?
        get() {
            val userJson = sharedPreferences.getString(USERPREF.user, "")
            return Gson().fromJson(userJson, UserDTO::class.java)
        }
        set(value) = editor.putString(USERPREF.user, Gson().toJson(value)).apply()
}