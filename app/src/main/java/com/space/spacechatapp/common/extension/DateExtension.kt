package com.space.spacechatapp.common.extension

import java.text.SimpleDateFormat
import java.util.*


fun Long.formatTime(): String {
    val calendar = Calendar.getInstance()
    val dayMonthFormat = SimpleDateFormat("dd/MM, HH:mm", Locale.getDefault())
    return dayMonthFormat.format(calendar.time)
}

fun getCurrentTime(): Long {
    return System.currentTimeMillis()
}

