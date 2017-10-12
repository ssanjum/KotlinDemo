package com.example.sanjum.kotlindemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnNextScreen: Button
    lateinit var buttonAction: Button
    var etText: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnNextScreen = findViewById(R.id.btnNext)
        buttonAction = findViewById(R.id.button_action)
        btnNextScreen.setOnClickListener(this)
        buttonAction.setOnClickListener(this)
        etText = findViewById(R.id.etText)
    }

    override fun onClick(v: View?) {

        if (v?.id == R.id.btnNext) {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
        if (v?.id == R.id.button_action) {
            if (etText?.text!!.isEmpty()) {
                etText?.setText(R.string.welcome_msg)
                buttonAction.setText("Clear Text")
            } else {
                etText?.setText("")
                buttonAction.setText("Show Text")
            }

        }

    }
}
