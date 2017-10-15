package com.example.sanjum.kotlindemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.appbar_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnNextScreen: Button
    lateinit var buttonAction: Button
    var etText: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar1)
        toolbar1.setTitleTextColor(resources.getColor(R.color.white))
        /* supportActionBar?.setDisplayHomeAsUpEnabled(true)
         supportActionBar?.setDisplayShowHomeEnabled(true)*/
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.menu_setting) {
            toast("TO DO")
        }
        return true

    }
}
