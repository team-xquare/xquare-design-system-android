package com.xquare.xquare_design_system_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xquare.xquare_design_system_playground.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}