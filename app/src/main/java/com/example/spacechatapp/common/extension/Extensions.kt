package com.example.spacechatapp.common.extension

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.TextView

@SuppressLint("NewApi")
fun ImageView.setTint(color:Int){
    this.imageTintList = ColorStateList.valueOf(this.context.getColor(color))
}

@SuppressLint("NewApi")
fun TextView.setBackgroundTint(color:Int){
    this.backgroundTintList = ColorStateList.valueOf(this.context.getColor(color))
}