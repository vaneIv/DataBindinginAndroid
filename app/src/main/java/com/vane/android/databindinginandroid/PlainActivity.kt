package com.vane.android.databindinginandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PlainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plain)
    }
}