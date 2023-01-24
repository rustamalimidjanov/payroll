package com.example.payroll.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import java.util.*

@Dao
interface MonthDao {
    @Query("SELECT * FROM crime")
    fun getMonths(): LiveData<List<Month>>

    @Query("SELECT * FROM crime WHERE id=(:id)")
    fun getMonth(id: UUID): LiveData<Month?>

    @Update
    fun updateMonth(month: Month)

    @Insert
    fun addMonth(month: Month)
}