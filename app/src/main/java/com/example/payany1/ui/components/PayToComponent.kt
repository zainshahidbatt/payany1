package com.example.payany1.ui.components

import com.example.payany1.databinding.PayToComponentBinding

class PayToComponent(
    binding: PayToComponentBinding,
    tv_name: String,
    accountNo: Long,
    bank_name: String

) {

    init {
        binding.apply {
            bankName.text = bank_name
            name.text = tv_name
            accountNumber.text = accountNo.toString()
        }
    }
}