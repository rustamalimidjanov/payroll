package com.example.payroll.presentation

import androidx.lifecycle.ViewModel
import com.example.payroll.data.models.MonthData
import com.example.payroll.data.database.MonthRepository

class MonthListViewModel: ViewModel() {
    private val monthRepository = MonthRepository.get()
    val crimeListLiveData = monthRepository.getMonths()

    fun addMonth(month: MonthData){
        monthRepository.addCrime(month = month)
    }
}