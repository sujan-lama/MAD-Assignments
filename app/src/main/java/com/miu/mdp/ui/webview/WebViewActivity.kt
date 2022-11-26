package com.miu.mdp.ui.webview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.miu.mdp.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    companion object {
        const val URL = "url"
        fun newInstance(context: Context, url: String, title: String): Intent {
            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra(URL, url)
            intent.putExtra("title", title)
            return intent
        }
    }

    private var _binding: ActivityWebViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityWebViewBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = intent.getStringExtra("title") ?: ""
        setContentView(binding.root)
        val url = intent.getStringExtra(URL) ?: ""
        with(binding.webview) {
            webViewClient = MyWebViewClient()
            settings.loadsImagesAutomatically = true
            settings.javaScriptEnabled = true
            loadUrl(url)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}