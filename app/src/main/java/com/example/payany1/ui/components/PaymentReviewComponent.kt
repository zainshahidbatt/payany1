package com.example.payany1.ui.components

import android.util.Log
import androidx.annotation.DrawableRes
import com.example.payany1.R
import com.example.payany1.data.adapters.ShapeAdapter

class PaymentReviewComponent(
    private val binding: com.example.payany1.databinding.PaymentReviewComponentBinding,
    @DrawableRes
private val icon: Int = R.drawable.icon_profile,
    private val senderName: String,
    private val senderAccountNo: Long,
    private val receiverName: String,
    private val receiverAccountNo: Long,
    private val receiverBankName: String,
    private val date: String
) {

    private val rvAdapter = ShapeAdapter()

    init {


        Log.e("this" , date)

        setupRecyclerView()
        binding.apply {
            tvDateText.text = date
            tvUserName.text = senderName
            tvAccountNumber.text = senderAccountNo.toString()
            ivProfile.setImageResource(icon)
            tvName.text = receiverName
            tvAccountNum.text = receiverAccountNo.toString()
            tvBankName.text = receiverBankName
        }
    }


    private fun setupRecyclerView() {
        binding.rvCircleShape.apply {
            adapter = rvAdapter
        }
    }

}