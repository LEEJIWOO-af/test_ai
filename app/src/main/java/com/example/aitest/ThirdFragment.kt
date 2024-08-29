package com.example.aitest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.aitest.api.DogApiService
import com.example.aitest.databinding.FragmentThirdBinding
import com.example.aitest.repository.DogRepository
import kotlinx.coroutines.launch

class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding
    private val dogRepository = DogRepository(DogApiService.create())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        fetchRandomDogImage()
        return binding?.root
    }

    private fun fetchRandomDogImage() {
        lifecycleScope.launch {
            dogRepository.getRandomDogImage().collect { imageUrl ->
                binding?.imageView?.let {
                    Glide.with(this@ThirdFragment)
                        .load(imageUrl)
                        .into(it)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}