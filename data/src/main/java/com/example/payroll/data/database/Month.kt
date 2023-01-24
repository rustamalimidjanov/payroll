package com.example.payroll.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Month(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    var title: String = "",
    var date: Date = Date(),
    var isSolved: Boolean = false,
)
