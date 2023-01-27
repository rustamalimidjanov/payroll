package com.example.payroll.data.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import java.util.*
import java.util.concurrent.Executors

private const val DATABASE_NAME = "crime-database"

class MonthRepository private constructor(context: Context) {

    private val database: MonthDatabase = Room.databaseBuilder(
        context.applicationContext,
        MonthDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val monthDao = database.monthDao()
    private val executor = Executors.newSingleThreadExecutor()
    private val filesDir = context.applicationContext.filesDir

    fun getMonths(): LiveData<List<MonthData>> = monthDao.getMonths()

    fun getMonth(id: UUID): LiveData<MonthData?> = monthDao.getMonth(id = id)

    fun updateCrime(month: MonthData) {
        executor.execute {
            monthDao.updateMonth(month = month)
        }
    }

    fun addCrime(month: MonthData) {
        executor.execute {
            monthDao.addMonth(month = month)
        }
    }

    companion object {
        private var INSTANCE: MonthRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = MonthRepository(context = context)
            }
        }

        fun get(): MonthRepository {
            return INSTANCE ?:
            throw IllegalStateException("CrimeRepository must be initialized")
        }
    }

}