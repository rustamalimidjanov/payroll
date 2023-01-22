package com.example.payroll.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.payroll.R
import com.example.payroll.databinding.FragmentCalendarBinding
import com.example.payroll.databinding.FragmentPayrollBinding
import ru.cleverpumpkin.calendar.CalendarDate
import ru.cleverpumpkin.calendar.CalendarView
import java.util.*

class PayrollFragment: Fragment() {
    lateinit var binding: FragmentCalendarBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val calendarView = binding.calendarView
        val calendar = Calendar.getInstance()
        calendar.set(2018, Calendar.JUNE, 1)
        val initialDate = CalendarDate(calendar.time)
        calendar.set(2018, Calendar.MAY, 15)
        val minDate = CalendarDate(calendar.time)
        calendar.set(2018, Calendar.JULY, 15)
        val maxDate = CalendarDate(calendar.time)

// The first day of week
        val firstDayOfWeek = java.util.Calendar.MONDAY
        calendarView.setupCalendar(
            initialDate = initialDate,
            minDate = minDate,
            maxDate = maxDate,
            selectionMode = CalendarView.SelectionMode.NONE,
            firstDayOfWeek = firstDayOfWeek,
            showYearSelectionView = true
        )

    }
}