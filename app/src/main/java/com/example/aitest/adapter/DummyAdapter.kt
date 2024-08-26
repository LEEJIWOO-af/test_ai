package com.example.aitest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aitest.databinding.ItemDummyBinding

class DummyAdapter(private val dummyList: List<String>) : RecyclerView.Adapter<DummyAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemDummyBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDummyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.item = dummyList[position]
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return dummyList.size
    }
}