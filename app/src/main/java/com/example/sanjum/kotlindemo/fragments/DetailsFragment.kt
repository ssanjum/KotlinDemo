package com.example.sanjum.kotlindemo.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sanjum.kotlindemo.ListModel

import com.example.sanjum.kotlindemo.R
import android.content.Intent
import android.net.Uri
import android.widget.Button


/**
 * A simple [Fragment] subclass.
 */
class DetailsFragment : Fragment(), View.OnClickListener {


    lateinit var bnd: Bundle
    lateinit var listmodel: ListModel
    lateinit var button: Button
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_details, container, false)
        button = view.findViewById(R.id.fr_image_button)
        button.setOnClickListener(this)
        return view
    }

    fun newInstance(listmodel: ListModel): Fragment {
        val frag: Fragment = DetailsFragment()
        var bnd = Bundle()
        bnd.putSerializable("name", listmodel)
        frag.arguments = bnd
        return frag
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bnd = arguments
        listmodel = bnd.getSerializable("name") as ListModel
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.fr_image_button) {
            val uri = Uri.parse(listmodel.trailerUrl) // missing 'http://' will cause crashed
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

}
