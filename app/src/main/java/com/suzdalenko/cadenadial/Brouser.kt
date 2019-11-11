package com.suzdalenko.cadenadial

import android.app.Activity
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_brouser.*

class Brouser : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brouser)


        webView.setWebViewClient(WebViewClient())
        webView.getSettings().setJavaScriptEnabled(true)
        val data: Uri? = getIntent().getData()
        webView.loadUrl(data.toString())
    }
}
