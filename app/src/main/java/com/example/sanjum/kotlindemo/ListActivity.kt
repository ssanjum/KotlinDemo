package com.example.sanjum.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import org.jetbrains.anko.toast
import java.util.ArrayList

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val recyClerView = findViewById<RecyclerView>(R.id.recyCler)
        recyClerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val listModel = ArrayList<ListModel>()
        listModel.add(ListModel("Shaheem", "Bareilly"))
        listModel.add(ListModel("Arif", "Rampur"))
        listModel.add(ListModel("Shaad", "Delhi"))
        listModel.add(ListModel("Handa", "Banaras"))
        listModel.add(ListModel("Amit", "Karnal"))
        listModel.add(ListModel("Saquib", "Punjab"))
        listModel.add(ListModel("AAkansha", "MP"))
        listModel.add(ListModel("Kanchan", "UP"))
        listModel.add(ListModel("Preeti", "Bengal"))
        listModel.add(ListModel("Saquib", "Punjab"))
        listModel.add(ListModel("AAkansha", "MP"))
        listModel.add(ListModel("Kanchan", "UP"))
        listModel.add(ListModel("Preeti", "Bengal"))
        listModel.add(ListModel("Saquib", "Punjab"))
        listModel.add(ListModel("AAkansha", "MP"))
        listModel.add(ListModel("Kanchan", "UP"))
        listModel.add(ListModel("Preeti", "Bengal"))

        val adapter=ListAdapter(listModel)
        recyClerView.adapter=adapter

        adapter.setOnListClickListener(object :ListAdapter.OnListClickListener{
            override fun onItemClick(pos: Int) {

                toast("clicked on"+pos)
            }
        })
    }
}
