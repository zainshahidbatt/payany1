package com.example.payany1.ui.reviewpayment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.payany1.base.BaseFragment
import com.example.payany1.databinding.FragmentReviewPaymentBinding
import com.example.payany1.ui.components.PaymentReviewComponent
import com.example.payany1.utils.currentDate
import com.example.payany1.utils.showBottomSheetDialog


class ReviewPaymentFragment : BaseFragment<FragmentReviewPaymentBinding>() {
    private val args by navArgs<ReviewPaymentFragmentArgs>()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentReviewPaymentBinding
        get() = FragmentReviewPaymentBinding::inflate

    @SuppressLint("SetTextI18n")
    override fun onCreatedView() {

        with(args) {
            PaymentReviewComponent(
                binding.paymentReview,
                senderName = senderData.holderName,
                senderAccountNo = senderData.accountNumber,
                receiverName = receiverData.name,
                receiverAccountNo = receiverData.accountNo,
                receiverBankName = receiverData.bankName,
                date = currentDate()
            )
            binding.amount.text = "$amount.00"
        }
        binding.btnContinue.btnContinue.apply {
            text = "Proceed to Pay"
            setOnClickListener {
                setOnClickListener {
                    with(args) {
                        showBottomSheetDialog(
                            amount = "$amount.00",
                            senderName = senderData.holderName,
                            senderAcNo = senderData.accountNumber.toString(),
                            receiverName = receiverData.name,
                            receiverAcNo = receiverData.accountNo.toString(),
                            date = currentDate(),
                        )
                    }
                }
            }
        }
    }
}