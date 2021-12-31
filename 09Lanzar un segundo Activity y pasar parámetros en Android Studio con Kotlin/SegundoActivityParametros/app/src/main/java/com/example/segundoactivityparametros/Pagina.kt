package com.example.segundoactivityparametros

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pagina.*


class Pagina : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina)

        val bundle = intent.extras
        val dato = bundle?.getString("direccion")
        wv1.setWebViewClient(WebViewClient())
        wv1.loadUrl("http://${dato}")

        b2.setOnClickListener {
            finish();
        }
    }
}