package com.example.payroll.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.payroll.data.models.MonthData


@Database(entities = [MonthData::class], version = 1)
@TypeConverters(MonthTypeConverters::class)
abstract class MonthDatabase: RoomDatabase() {

    abstract fun monthDao(): MonthDao

}