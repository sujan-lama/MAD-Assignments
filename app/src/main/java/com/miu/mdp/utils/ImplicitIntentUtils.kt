package com.miu.mdp.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.miu.mdp.ui.webview.WebViewActivity

fun String.startPhoneIntent(context: Context) {
    if (this.isEmpty() || !this.validatePhone()) {
        return
    }
    try {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$this")
        context.startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(context, "No application found to handle this action", Toast.LENGTH_SHORT)
            .show()
    }
}


fun String.startEmailIntent(context: Context) {
    if (this.isEmpty() || !this.validateEmail()) {
        return
    }
    try {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:$this")
        context.startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(context, "No application found to handle this action", Toast.LENGTH_SHORT)
            .show()
    }
}

fun String.startWebIntent(context: Context) {
    if (this.isEmpty() || !this.validateURL()) {
        return
    }
    try {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(this)
        context.startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(context, "No application found to handle this action", Toast.LENGTH_SHORT)
            .show()
    }
}

fun String.startWebView(context: Context) {
    if (this.isEmpty() || !this.validateURL()) {
        return
    }
    try {
        val intent = Intent(context, WebViewActivity::class.java)
        intent.putExtra(WebViewActivity.URL, this)
        context.startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(context, "No application found to handle this action", Toast.LENGTH_SHORT)
            .show()
    }
}

