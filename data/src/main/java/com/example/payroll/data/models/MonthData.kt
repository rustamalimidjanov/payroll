package com.example.payroll.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class MonthData(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    var title: String = "",
    var date: Date = Date(),
    var isSolved: Boolean = false,
)
