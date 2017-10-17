package com.example.sanjum.kotlindemo.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sanjum.kotlindemo.ListModel

import com.example.sanjum.kotlindemo.R
import kotlinx.android.synthetic.main.fragment_movie.*


/**
 * A simple [Fragment] subclass.
 */
class MoviesFragment : Fragment() {
    lateinit var bnd: Bundle
    lateinit var listmodel: ListModel
    val textView: TextView? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_movie, container, false)

    }

    fun newInstance(listmodel: ListModel): Fragment {
        val frag: Fragment = MoviesFragment()
        var bnd = Bundle()
        bnd.putSerializable("name", listmodel)
        frag.arguments = bnd
        return frag
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bnd = arguments

        listmodel = bnd.getSerializable("name") as ListModel
        fr_title.text=listmodel.name
        fr_year.text= listmodel.year.toString()
        fr_rating.text= listmodel.rating.toString()
        fr_imageview.setImageResource(listmodel.imageId)
        //var name:String=bnd.getString("name")


    }

}// Required empty public constructor
