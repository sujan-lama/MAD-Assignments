package com.miu.mdp.utils

import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.validateEmail(): Boolean {
    val email = editText?.text.toString().trim()
    return if (email.isEmpty()) {
        helperText = "Email is required"
        false
    } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
        helperText = "Email is not valid"
        false
    } else {
        helperText = null
        true
    }
}

fun TextInputLayout.validatePassword(): Boolean {
    val password = editText?.text.toString().trim()
    return if (password.isEmpty()) {
        helperText = "Password is required"
        false
    } else {
        helperText = null
        true
    }
}

fun TextInputLayout.validateEmpty(): Boolean {
    val text = editText?.text.toString().trim()
    return if (text.isEmpty()) {
        helperText = "This field is required"
        false
    } else {
        helperText = null
        true
    }
}

