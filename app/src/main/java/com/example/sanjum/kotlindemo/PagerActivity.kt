package com.example.sanjum.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.sanjum.kotlindemo.fragments.DetailsFragment
import com.example.sanjum.kotlindemo.fragments.MoviesFragment
import kotlinx.android.synthetic.main.activity_pager.*
import kotlinx.android.synthetic.main.appbar_main.*

class PagerActivity : AppCompatActivity() {

    var customPagerAdapter: CustomPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager)
        setSupportActionBar(toolbar1)
        toolbar1.setTitleTextColor(resources.getColor(R.color.white))
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar1.setNavigationOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                finish()
            }
        })
        var listmodel: ListModel = intent.getSerializableExtra("LIST") as ListModel
        customPagerAdapter = CustomPagerAdapter(supportFragmentManager)
        customPagerAdapter?.addFragment(MoviesFragment().newInstance(listmodel), "Movies")
        customPagerAdapter?.addFragment(DetailsFragment().newInstance(listmodel), "Details")
        pager.adapter = customPagerAdapter
        tabbLayout.setupWithViewPager(pager)

    }

}
