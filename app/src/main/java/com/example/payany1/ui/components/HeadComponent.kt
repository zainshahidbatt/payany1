package com.example.payany1.ui.components

import com.example.payany1.databinding.TopProfileComponentBinding

class HeadComponent (
    binding: TopProfileComponentBinding,
    private val title: String,
    onClicked: () -> Unit
) {
    init {
        binding.apply {
            headerTitle.text=title
            icBack.setOnClickListener {
                onClicked()
            }
        }
    }
}