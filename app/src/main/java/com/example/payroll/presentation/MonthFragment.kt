package com.example.payroll.presentation

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.payroll.databinding.FragmentMonthBinding
import java.util.*

private const val ARG_MONTH_ID = "month_id"

class MonthFragment: Fragment() {
    lateinit var binding: FragmentMonthBinding

    companion object {

        fun newInstance(crimeId: UUID): MonthFragment {
            val args = Bundle().apply {
                putSerializable(ARG_MONTH_ID, crimeId)
            }
            return MonthFragment().apply {
                arguments = args
            }
        }
    }
}