package com.example.payroll.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.payroll.data.models.MonthData
import java.util.*

@Dao
interface MonthDao {
    @Query("SELECT * FROM month-data")
    fun getMonths(): LiveData<List<MonthData>>

    @Query("SELECT * FROM month-data WHERE id=(:id)")
    fun getMonth(id: UUID): LiveData<MonthData?>

    @Update
    fun updateMonth(month: MonthData)

    @Insert
    fun addMonth(month: MonthData)


}