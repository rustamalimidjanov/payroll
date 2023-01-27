package com.example.payroll.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.payroll.R
import com.example.payroll.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), Callbacks {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val container = R.id.frame_container
        val currentFragment = supportFragmentManager.findFragmentById(container)

        if (currentFragment == null) {
            val fragment = MonthListFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(container, fragment)
                .commit()
        }

    }

    override fun onMonthSelected(id: UUID) {

    }
}