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

        listModel.add(ListModel("Mad Max: Fury Road", "Action & Adventure"))
                listModel.add(ListModel("Inside Out", "Animation, Kids & Family"))
                listModel.add(ListModel("Star Wars: Episode VII - The Force Awakens", "Action"))
                listModel.add(ListModel("Shaun the Sheep", "Animation"))
                listModel.add(ListModel("The Martian", "Science Fiction & Fantasy"))
                listModel.add(ListModel("Mission: Impossible Rogue Nation", "Action"))
                listModel.add(ListModel("Up", "Animation"))
                listModel.add(ListModel("Star Trek", "Science Fiction"))
                listModel.add(ListModel("The LEGO Movie", "Animation"))
                listModel.add(ListModel("Iron Man", "Action & Adventure"))
                listModel.add(ListModel("Aliens", "Science Fiction"))
                listModel.add(ListModel("Chicken Run", "Animation"))
                listModel.add(ListModel("Back to the Future", "Science Fiction"))
                listModel.add(ListModel("Raiders of the Lost Ark", "Action & Adventure" ))
                listModel.add(ListModel("Goldfinger", "Action & Adventure" ))
                listModel.add(ListModel("Guardians of the Galaxy", "Science Fiction & Fantasy"))


        val adapter=ListAdapter(listModel)
        recyClerView.adapter=adapter

        adapter.setOnListClickListener(object :ListAdapter.OnListClickListener{
            override fun onItemClick(pos: Int) {
             val model:ListModel=   adapter.getnameAtPosition(pos)
                toast("clicked on" + model.name + " at position " + pos)
            }
        })
    }
}
