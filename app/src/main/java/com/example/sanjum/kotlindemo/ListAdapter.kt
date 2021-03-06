package com.example.sanjum.kotlindemo


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Created by sanjum on 10/11/2017.
 */
class ListAdapter(val listmodel: ArrayList<MovieListModel>) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    var listener: OnListClickListener? = null

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        val listUser: MovieListModel = listmodel[position]
        holder?.textViewName?.text = listUser.name
        holder?.textViewAddress?.text = listUser.genure
        holder?.textViewRating?.text = listUser.rating.toString()
        holder?.textViewYear?.text = listUser.year.toString()
        holder?.linearLayout?.setOnClickListener { listener?.onItemClick(position) }
    }

    interface OnListClickListener {
        fun onItemClick(pos: Int)
    }

    fun setOnListClickListener(listener: OnListClickListener) {
        this.listener = listener

    }

    fun getnameAtPosition(pos: Int): MovieListModel {
        val listUser: MovieListModel = listmodel[pos]
        return listUser

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listmodel.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName = itemView.findViewById<TextView>(R.id.tv_name)
        val textViewAddress = itemView.findViewById<TextView>(R.id.tv_address)
        val linearLayout = itemView.findViewById<LinearLayout>(R.id.ll_item)
        val textViewRating = itemView.findViewById<TextView>(R.id.tv_rating)
        val textViewYear = itemView.findViewById<TextView>(R.id.tv_year)


    }
}