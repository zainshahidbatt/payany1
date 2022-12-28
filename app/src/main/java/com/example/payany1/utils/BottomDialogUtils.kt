package com.example.payany1.utils

import androidx.fragment.app.Fragment
import com.example.payany1.R
import com.example.payany1.databinding.PaymentSentDailogBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

fun Fragment.showBottomSheetDialog(
    amount: String,
    senderName: String,
    senderAcNo: String,
    receiverName: String,
    receiverAcNo: String,
    date: String,
//    action: () -> Unit,
) {
    BottomSheetDialog(requireContext(), R.style.SheetDialog).also { dialog ->
        val binding = PaymentSentDailogBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        dialog.behavior.isDraggable = false
        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        binding.apply {
            tvAmount.text = amount
            tvSenderName.text = senderName
            tvSenderAcNo.text = senderAcNo
            tvReceiverName.text = receiverName
            tvReceiverAcNo.text = receiverAcNo
            tvDate.text = date
            ivCross.setOnClickListener {
                dialog.dismiss()
//                action.invoke()
            }
        }
        dialog.show()
    }
}