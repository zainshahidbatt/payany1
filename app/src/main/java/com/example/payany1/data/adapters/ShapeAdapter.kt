package com.example.payany1.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.payany1.databinding.ItemReviewPaymentBinding

class ShapeAdapter : RecyclerView.Adapter<ShapeAdapter.ShapeViewHolder>() {

    inner class ShapeViewHolder(val binding: ItemReviewPaymentBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShapeViewHolder {
        val binding =
            ItemReviewPaymentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShapeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShapeViewHolder, position: Int) {

    }

    override fun getItemCount() = 20

}