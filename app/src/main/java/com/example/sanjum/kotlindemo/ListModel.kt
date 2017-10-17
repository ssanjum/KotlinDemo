package com.example.sanjum.kotlindemo

import java.io.Serializable

/**
 * Created by sanjum on 10/11/2017.
 */

data class ListModel(val name: String, val genure: String,val rating:Float,val year:Int,val imageId:Int,val trailerUrl:String):Serializable
