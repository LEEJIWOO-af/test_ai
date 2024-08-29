package com.example.aitest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aitest.adapter.DummyAdapter
import com.example.aitest.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        // make dummy list data and make adapter for recycler view and connect it.
        val dummyList = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
        val adapter = DummyAdapter(dummyList)
        _binding?.recyclerView?.layoutManager = LinearLayoutManager(context)
        _binding?.recyclerView?.adapter = adapter

        return _binding?.root
    }
}