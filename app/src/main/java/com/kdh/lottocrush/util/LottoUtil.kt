package com.kdh.lottocrush.util

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

object LottoUtil {

    fun getNextEpisodeBasedonDate(): Int {
        val startDate = "2002-12-14 23:59:59"
        val dateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
        val cDate = Date()
        val sDate: Date = dateFormat.parse(startDate) as Date
        val diff: Long = cDate.time - sDate.time
        val nextEpi = diff / (86400 * 1000 * 7) + 2
        Log.d("dodo55 ","cDate ${cDate}")
        Log.d("dodo55 ","sDate ${sDate}")
        Log.d("dodo55 ","diff ${diff}")
        Log.d("dodo55 ","nextEpi ${nextEpi}")
        return nextEpi.toInt()
    }
}