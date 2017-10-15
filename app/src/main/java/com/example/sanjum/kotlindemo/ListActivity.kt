package com.example.sanjum.kotlindemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.appbar_main.*
import org.jetbrains.anko.toast
import java.util.ArrayList

class ListActivity : AppCompatActivity() {
    lateinit var bnd: Bundle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setSupportActionBar(toolbar1)
        toolbar1.setTitleTextColor(resources.getColor(R.color.white))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar1.setNavigationOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                finish()
            }
        })
        val recyClerView = findViewById<RecyclerView>(R.id.recyCler)
        recyClerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val data: ArrayList<ListModel>
        data = getData()
        val adapter = ListAdapter(data)
        recyClerView.adapter = adapter

        adapter.setOnListClickListener(object : ListAdapter.OnListClickListener {
            override fun onItemClick(pos: Int) {
                val model: ListModel = adapter.getnameAtPosition(pos)
                val intent = Intent(baseContext, PagerActivity::class.java)
                bnd = Bundle()
                bnd.putSerializable("LIST", model)
                intent.putExtras(bnd)
                startActivity(intent)

            }
        })
    }

    fun getData(): ArrayList<ListModel> {
        val listModel = ArrayList<ListModel>()

        listModel.add(ListModel("Mad Max: Fury Road", "Action & Adventure", 8.1f, 2015, R.drawable.madmax))
        listModel.add(ListModel("Inside Out", "Animation, Kids & Family", 8.2f, 2015, R.drawable.insideout))
        listModel.add(ListModel("Star Wars: Episode VII - The Force Awakens", "Action", 8.1f, 2015, R.drawable.starwars))
        listModel.add(ListModel("Shaun the Sheep", "Animation", 7.4f, 2015, R.drawable.shaun))
        listModel.add(ListModel("The Martian", "Science Fiction & Fantasy", 8f, 2015, R.drawable.martian))
        listModel.add(ListModel("Mission: Impossible Rogue Nation", "Action", 7.4f, 2015, R.drawable.rougue))
        listModel.add(ListModel("Up", "Animation", 8.3f, 2009, R.drawable.up))
        listModel.add(ListModel("Star Trek", "Science Fiction", 8f, 2009, R.drawable.startrek))
        listModel.add(ListModel("The LEGO MovieFragment", "Animation", 7.8f, 2014, R.drawable.lego))
        listModel.add(ListModel("Iron Man", "Action & Adventure", 7.9f, 2008, R.drawable.ironman))
        listModel.add(ListModel("Aliens", "Science Fiction", 8.4f, 1986, R.drawable.aliens))
        listModel.add(ListModel("Chicken Run", "Animation", 7f, 2000, R.drawable.chicken))
        listModel.add(ListModel("Back to the Future", "Science Fiction", 8.5f, 1985, R.drawable.backtofuture))
        listModel.add(ListModel("Back to the Future", "Science Fiction", 8.5f, 1985, R.drawable.backtofuture))
        listModel.add(ListModel("The Martian", "Science Fiction & Fantasy", 8f, 2015, R.drawable.martian))
        listModel.add(ListModel("Mission: Impossible Rogue Nation", "Action", 7.4f, 2015, R.drawable.up))
        listModel.add(ListModel("Up", "Animation", 8.3f, 2009, R.drawable.up))
        listModel.add(ListModel("Star Trek", "Science Fiction", 8f, 2009, R.drawable.startrek))
        listModel.add(ListModel("The LEGO MovieFragment", "Animation", 7.8f, 2014, R.drawable.lego))
        listModel.add(ListModel("Iron Man", "Action & Adventure", 7.9f, 2008, R.drawable.ironman))
        listModel.add(ListModel("Iron Man", "Action & Adventure", 7.9f, 2008, R.drawable.ironman))
        listModel.add(ListModel("The Martian", "Science Fiction & Fantasy", 8f, 2015, R.drawable.martian))
        listModel.add(ListModel("Mission: Impossible Rogue Nation", "Action", 7.4f, 2015, R.drawable.rougue))
        listModel.add(ListModel("Up", "Animation", 8.3f, 2009, R.drawable.up))
        listModel.add(ListModel("Star Trek", "Science Fiction", 8f, 2009, R.drawable.startrek))
        listModel.add(ListModel("Aliens", "Science Fiction", 8.4f, 1986, R.drawable.aliens))
        listModel.add(ListModel("Mad Max: Fury Road", "Action & Adventure", 8.1f, 2015, R.drawable.madmax))
        return listModel
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_movie_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.menu_filter) {
            toast("TO DO")
        }
        if (item?.itemId == R.id.menu_clear) {
            toast("TO DO")
        }
        return true

    }
}
