package com.triare.p131todolistapp.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    @SuppressLint("SimpleDateFormat")
    fun parseDate(): String {
        val date = Calendar.getInstance().time
        val formatter = SimpleDateFormat("d MMM HH:mm:ss")
        return formatter.format(date)
    }
}