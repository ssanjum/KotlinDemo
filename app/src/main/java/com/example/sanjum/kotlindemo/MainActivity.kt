package com.example.sanjum.kotlindemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar1)
        toolbar1.setTitleTextColor(resources.getColor(R.color.white))
        btnNext.setOnClickListener(this)
        button_action.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        if (v?.id == R.id.btnNext) {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
        if (v?.id == R.id.button_action) {
            if (etText?.text!!.isEmpty()) {
                etText?.setText(R.string.welcome_msg)
                button_action.setText("Clear Text")
            } else {
                etText?.setText("")
                button_action.setText("Show Text")
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
