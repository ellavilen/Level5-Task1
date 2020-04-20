package com.example.level5_task1

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?) : Date?{
        return value?.let {Date(it)}
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?) : Long?{
        return date?.time?.toLong()
    }
}