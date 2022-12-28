package com.example.payany1.ui.components

import com.example.payany1.databinding.PayDetailsComponentBinding

class PayeeDetailsComponent(
    binding: PayDetailsComponentBinding,
    private val icon: Int,
    payee_Name: String,
    account_Number: Long,
    bank_Name: String,
) {
    init {
        binding.apply {
            profileImage.setImageResource(icon)
            payeeName.text = payee_Name
            accountNumber.text = account_Number.toString()
            bankName.text = bank_Name
        }
    }
}