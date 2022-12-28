package com.example.payany1.ui.enterammount

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.payany1.base.BaseFragment
import com.example.payany1.databinding.FragmentEnterAmountBinding
import com.example.payany1.ui.components.HeadComponent
import com.example.payany1.utils.navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EnterAmountFragment : BaseFragment<FragmentEnterAmountBinding>() {
    private val args by navArgs<EnterAmountFragmentArgs>()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentEnterAmountBinding
        get() = FragmentEnterAmountBinding::inflate


    @SuppressLint("SetTextI18n")
    override fun onCreatedView() {
        HeadComponent(
            binding = binding.top,
            title = "pay"
        ) {
            findNavController().navigateUp()
        }
        binding.apply {
            componentProceedToPay.apply {
                btnContinue.text = "Proceed To Pay"
                btnContinue.setOnClickListener {
                    val amount = amount.text.toString()
                    if (amount.isNotEmpty()) {
                        val action =
                            EnterAmountFragmentDirections.actionEnterAmountFragmentToReviewPaymentFragment(
                                amount,
                                args.accountData,
                                args.payeeDetials
                            )
                        navigation(action)
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Please fill out the amount",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

}