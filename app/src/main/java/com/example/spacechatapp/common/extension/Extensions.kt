package com.example.spacechatapp.common.extension

import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

fun ImageView.setTint(color:Int){
    this.imageTintList = ColorStateList.valueOf(this.context.getColor(color))
}

fun TextView.setBackgroundTint(color:Int){
    this.backgroundTintList = ColorStateList.valueOf(this.context.getColor(color))
}

fun getCurrentDateTime(): String {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
    return dateFormat.format(Date())
}