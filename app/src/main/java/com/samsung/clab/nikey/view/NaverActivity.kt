package com.samsung.clab.nikey.view

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.samsung.clab.nikey.R
import com.samsung.clab.nikey.databinding.ActivityNaverBinding
import com.samsung.clab.nikey.viewModel.NaverViewModel

class NaverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityNaverBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_naver)
        binding.viewModel = ViewModelProvider(this)[NaverViewModel::class.java]
        initWebView(binding.root)
    }

    private fun initWebView(view: View) {
        val webView = view.findViewById<WebView>(R.id.webView)
        webView.loadUrl("https://m.naver.com")
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return super.onKeyDown(keyCode, event)
        Log.i(">>>> TEST", "keyCode: $keyCode")
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        return super.onKeyUp(keyCode, event)
        Log.i(">>>> TEST", "keyCode: $keyCode")

    }
}
