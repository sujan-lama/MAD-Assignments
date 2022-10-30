package com.miu.mdp.data

import android.content.SharedPreferences
import com.google.gson.Gson
import com.miu.mdp.constants.USERPREF
import com.miu.mdp.model.User
import javax.inject.Inject

class SharedPreferenceHelper @Inject constructor(private val sharedPreferences: SharedPreferences) {

    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    var user: User?
        get() {
            val userJson = sharedPreferences.getString(USERPREF.user, "")
            return Gson().fromJson(userJson, User::class.java)
        }
        set(value) = editor.putString(USERPREF.user, Gson().toJson(value)).apply()

    var userList: List<User>
        get() {
            val userJson = sharedPreferences.getString(USERPREF.userList, "[]")
            return Gson().fromJson(userJson, Array<User>::class.java).toList()
        }
        set(value) = editor.putString(USERPREF.userList, Gson().toJson(value)).apply()

    fun addUser(user: User) {
        val userList = userList.toMutableList()
        userList.add(user)
        this.userList = userList
    }
}