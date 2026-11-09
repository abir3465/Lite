package com.abir3465.lite

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        val backButton = findViewById<Button>(R.id.backButton)
        val homeButton = findViewById<Button>(R.id.homeButton)
        val refreshButton = findViewById<Button>(R.id.refreshButton)

        webView = findViewById(R.id.webView)

        val settings: WebSettings = webView.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
.host ?: return false

                val allowedHosts = listOf(
                    "m.facebook.com",
                    "www.facebook.com",
                    "facebook.com",
                    "fbcdn.net",
                    "static.xx.fbcdn.net",
                    "business.facebook.com",
                    "l.facebook.com"
                )

                val staysInWebView =
                    allowedHosts.any { host == it || host.endsWith(".$it") }

                if (staysInWebView) return false

                startActivity(Intent(Intent.ACTION_VIEW, url))
                return true
            }
        }

        backButton.setOnClickListener {
            if (webView.canGoBack()) webView.goBack()
        }

        homeButton.setOnClickListener {
            webView.loadUrl("https://m.facebook.com")
        }

        refreshButton.setOnClickListener {
            webView.reload()
        }

        toolbar.setNavigationOnClickListener {
            if (webView.canGoBack()) webView.goBack()
        }

        toolbar.setOnMenuItemClickListener { menuItem ->
            if (menuItem.itemId == R.id.action_open_browser) {
                val uri = Uri.parse(webView.url ?: "https://m.facebook.com")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
                true
            } else {
                false
            }
        }

        webView.loadUrl("https://m.facebook.com")
    }

    @Deprecated("Deprecated in Android")
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
