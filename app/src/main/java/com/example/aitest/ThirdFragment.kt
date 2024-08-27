package com.example.aitest

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aitest.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    private var isRunning = false
    private var elapsedTime = 0L
    private val handler = Handler(Looper.getMainLooper())
    private val updateInterval = 1000L

    private val updateTimeRunnable = object : Runnable {
        override fun run() {
            if (isRunning) {
                elapsedTime += 1
                binding.tvStopwatch.text = formatTime(elapsedTime)
                handler.postDelayed(this, updateInterval)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)

        binding.btnStart.setOnClickListener {
            if (!isRunning) {
                isRunning = true
                handler.post(updateTimeRunnable)
            }
        }

        binding.btnStop.setOnClickListener {
            isRunning = false
        }

        binding.btnReset.setOnClickListener {
            isRunning = false
            elapsedTime = 0L
            binding.tvStopwatch.text = formatTime(elapsedTime)
        }

        return binding.root
    }

    private fun formatTime(seconds: Long): String {
        val hrs = seconds / 3600
        val mins = (seconds % 3600) / 60
        val secs = seconds % 60
        return String.format("%02d:%02d:%02d", hrs, mins, secs)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        handler.removeCallbacks(updateTimeRunnable)
    }
}