package com.example.payany1.ui.payee_details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.payany1.base.BaseFragment
import com.example.payany1.databinding.FragmentPayeeDetailsFragmentBinding
import com.example.payany1.ui.components.HeadComponent
import com.example.payany1.ui.components.PayeeDetailsComponent
import com.example.payany1.utils.navigation

class PayeeDetailsFragment : BaseFragment<FragmentPayeeDetailsFragmentBinding>() {
    private val args by navArgs<PayeeDetailsFragmentArgs>()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPayeeDetailsFragmentBinding =
        FragmentPayeeDetailsFragmentBinding::inflate


    @SuppressLint("SetTextI18n")
    override fun onCreatedView() {
        HeadComponent(
            binding = binding.topComponent,
            title = "Account Details"
        ) {
            findNavController().navigateUp()
        }
        args.payeeDetails.apply {
            PayeeDetailsComponent(
                binding = binding.componentPayeeDetails,
                icon = image,
                payee_Name = name,
                account_Number = accountNo,
                bank_Name = bankName
            )
        }

        binding.btnContinue.apply {
            btnContinue.text = "Pay Now"
            btnContinue.setOnClickListener {
                val action =
                    PayeeDetailsFragmentDirections.actionPayeeDetailsFragmentToPayToAnyonePayFragment(
                        args.payeeDetails
                    )
                navigation(action)
            }
        }
    }
}