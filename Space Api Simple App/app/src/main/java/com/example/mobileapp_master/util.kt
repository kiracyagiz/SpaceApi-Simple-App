package com.example.mobileapp_master

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

fun ImageView.setPicture(url: String?) {

    if (url != null){
        Glide.with(this).load(url).into(this)
    }
    else{

    }

}

fun View.show(){
    visibility = View.VISIBLE
}

fun View.notShow(){
    visibility = View.GONE
}