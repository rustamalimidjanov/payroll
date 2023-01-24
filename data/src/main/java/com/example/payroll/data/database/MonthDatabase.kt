package com.example.payroll.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [Month::class], version = 1)
@TypeConverters(MonthTypeConverters::class)
abstract class MonthDatabase: RoomDatabase() {

    abstract fun monthDao(): MonthDao

}