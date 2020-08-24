package com.sermage.chucknorrisjokesapp.screens

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.sermage.chucknorrisjokesapp.R


class WebFragment : Fragment() {

   private val url="http://www.icndb.com/api/"
    private lateinit var webView:WebView

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        webView.saveState(outState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_web, container, false)
        webView=root.findViewById(R.id.webViewApiInfo)
        webView.settings.javaScriptEnabled=true
        if(savedInstanceState==null){
            webView.loadUrl(url)
        }else{
            webView.restoreState(savedInstanceState)
        }

        webView.webViewClient= MyWebViewClient()
        return root
    }

    private class MyWebViewClient:WebViewClient(){

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url)
            return true
        }
        @TargetApi(Build.VERSION_CODES.N)
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            view?.loadUrl(request?.url.toString())
            return true
        }
    }


}