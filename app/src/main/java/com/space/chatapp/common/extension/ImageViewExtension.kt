package com.space.chatapp.common.extension

import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes


fun TextView.setTextBackgroundTint(@ColorRes colorRes: Int) {
    this.setTextColor(context.getColor(colorRes))
}

fun ImageView.setTint(color: Int) {
    this.imageTintList = ColorStateList.valueOf(this.context.getColor(color))
}

fun TextView.setBackgroundTint(color: Int) {
    this.backgroundTintList = ColorStateList.valueOf(this.context.getColor(color))
}

