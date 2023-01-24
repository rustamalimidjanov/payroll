package com.example.payroll.app

import android.app.Application
import com.example.payroll.data.database.MonthRepository

class MonthIntentApp: Application() {

    override fun onCreate() {
        super.onCreate()
        MonthRepository.initialize(this)
    }
}