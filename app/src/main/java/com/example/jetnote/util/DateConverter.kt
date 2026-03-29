package com.example.jetnote.util

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {

    @TypeConverter
    fun timeStampFromData(date: Date): Long{
        return date.time
    }
    @TypeConverter
    fun dataFromTimeStamp(timeStamp: Long): Date?{
        return Date(timeStamp)
    }
}