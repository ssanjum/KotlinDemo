package com.example.sanjum.kotlindemo

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by ANJUM on 10/14/2017.
 */
class CustomPagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {
    var mFragmentsItem:ArrayList<Fragment> =ArrayList()
    var mFragmentTitle:ArrayList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return mFragmentsItem[position]

    }

    override fun getCount(): Int {
        return mFragmentsItem.size
    }
    fun addFragment(fragment:Fragment,fragmentTitle:String){

        mFragmentsItem.add(fragment)
        mFragmentTitle.add(fragmentTitle)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mFragmentTitle[position]
    }
}