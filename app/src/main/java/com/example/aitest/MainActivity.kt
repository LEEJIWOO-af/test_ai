package com.example.aitest

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aitest.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            generateRandomNumber()
        }
    }

    private fun generateRandomNumber() {
        val randomNumber = Random.nextInt(1, 21)
        try {
            if (randomNumber in 1..10) {
                Toast.makeText(this, "Number: $randomNumber", Toast.LENGTH_SHORT).show()
            } else {
                throw Exception("Number is out of range: $randomNumber")
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}