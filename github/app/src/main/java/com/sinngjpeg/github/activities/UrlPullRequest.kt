package com.sinngjpeg.github.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.sinngjpeg.github.R

class UrlPullRequest : AppCompatActivity() {

    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.url_activity)
        webView = findViewById(R.id.url_view)
        val url = intent.getStringExtra(EXTRA_URL)
        webView.settings.setJavaScriptEnabled(true)
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url.toString())
                return true
            }
        }
        webView.loadUrl(url.toString())
    }

    companion object {
        private const val EXTRA_URL = "EXTRA_URL"

        fun getStartUrlIntent(
            context: Context,
            url: String
        ): Intent {
            return Intent(context, UrlPullRequest::class.java).apply {
                putExtra(EXTRA_URL, url)
            }
        }
    }
}