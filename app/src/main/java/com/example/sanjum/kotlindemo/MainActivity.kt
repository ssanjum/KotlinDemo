package com.example.sanjum.kotlindemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnClick: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnClick = findViewById(R.id.btnClick)
        btnClick.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        //  toast("Hello world")
        val intent=Intent(this,ListActivity::class.java)
        startActivity(intent)
    }
}
