package com.space.chatapp.common.extension

import java.text.SimpleDateFormat
import java.util.*


fun Long.formatTime(): String {
    val georgianLocale = Locale("ka", "GE")
    val calendar = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("MMM d HH:mm", georgianLocale)
    calendar.timeInMillis = this
    return dateFormat.format(calendar.time)
}

fun getCurrentTime(): Long {
    return System.currentTimeMillis()
}

