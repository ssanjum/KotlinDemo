package com.example.sanjum.kotlindemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnShowText: Button
    lateinit var btnNextScreen: Button
    lateinit var btnClear: Button
    var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnNextScreen = findViewById(R.id.btnNext)
        btnShowText = findViewById(R.id.btnShowText)
        btnClear = findViewById(R.id.btnClear)
        btnShowText.setOnClickListener(this)
        btnNextScreen.setOnClickListener(this)
        btnClear.setOnClickListener(this)
        textView = findViewById(R.id.tvTextView)
    }

    override fun onClick(v: View?) {

        if (v?.id == R.id.btnShowText) {
            textView?.text = "WelCome To Kotlin"
        }
        if (v?.id == R.id.btnNext) {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
        if (v?.id == R.id.btnClear) {
            textView?.text=""
        }

    }
}
