package com.space.spacechatapp.common.extension

import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.TextView

fun ImageView.setTint(color:Int){
    this.imageTintList = ColorStateList.valueOf(this.context.getColor(color))
}

fun TextView.setBackgroundTint(color:Int){
    this.backgroundTintList = ColorStateList.valueOf(this.context.getColor(color))
}
