package com.example.payroll.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.payroll.R
import com.example.payroll.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.frame_container, PayrollFragment())
            .commit()

    }
}