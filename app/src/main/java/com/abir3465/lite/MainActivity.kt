package com.abir3465.lite

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.CookieManager
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webView)

        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true)

        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            databaseEnabled = true
            allowFileAccess = false
            loadsImagesAutomatically = true
            useWideViewPort = true
            loadWithOverviewMode = true
        }

        webView.webViewClient = object : WebViewClient() {

    private fun handleLink(view: WebView?, uri: android.net.Uri): Boolean {
        if (uri.scheme == "http" || uri.scheme == "https") {
            return false // Keep normal websites inside the APK.
        }

        if (uri.scheme == "intent" || uri.scheme == "fb-messenger") {
            view?.loadUrl("https://web.messenger.com/")
        }

        return true // Don't try to launch another app.
    }

    override fun shouldOverrideUrlLoading(
        view: WebView?,
        request: WebResourceRequest
    ): Boolean = handleLink(view, request.url)

    @Suppress("DEPRECATION")
    override fun shouldOverrideUrlLoading(
        view: WebView?,
        url: String?
    ): Boolean {
        if (url == null) return true
        return handleLink(view, android.net.Uri.parse(url))
    }
}
        webView.loadUrl("https://m.facebook.com/")
    }
}
