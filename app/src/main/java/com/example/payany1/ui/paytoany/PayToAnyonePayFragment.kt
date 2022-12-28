package com.example.payany1.ui.paytoany

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.payany1.base.BaseFragment
import com.example.payany1.data.models.AccountData
import com.example.payany1.databinding.FragmentPayToAnyonePayBinding
import com.example.payany1.ui.components.AccountSelectionComponent
import com.example.payany1.ui.components.HeadComponent
import com.example.payany1.ui.components.PayToComponent
import com.example.payany1.ui.components.PurposeComponent
import com.example.payany1.ui.dashboard.DashBoardVM
import com.example.payany1.utils.navigation
import com.example.payany1.utils.visibility
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PayToAnyonePayFragment : BaseFragment<FragmentPayToAnyonePayBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPayToAnyonePayBinding =
        FragmentPayToAnyonePayBinding::inflate

    private val viewModel by viewModels<DashBoardVM>()
    private val args by navArgs<PayToAnyonePayFragmentArgs>()
    private var accountData: AccountData? = null

    override fun onCreatedView() {

        HeadComponent(
            binding = binding.topComponent,
            title = "Repatriate Funds"
        ) {
            findNavController().navigateUp()
        }

        AccountSelectionComponent(
            binding.includePayToDetails,
            viewModel.accountList,
            currentAccount = {
                accountData = it
            },
            action = { isCollapsed ->
                binding.groupAccount.visibility(isCollapsed)
            }
        )

        args.payeeDetails.apply {
            PayToComponent(
                binding = binding.selectAccountLayout,
                tv_name = name,
                accountNo = accountNo,
                bank_name = bankName
            )
        }

        PurposeComponent(
            binding = binding.componentPurpose,
            list = viewModel.purposeList,
            text = "Purpose",
            titleText = "Select Purpose",
            action = { isCollapsed ->
                binding.groupRelation.visibility(isCollapsed)
            }
        )

        PurposeComponent(
            binding = binding.componentRelation,
            list = viewModel.relationList,
            text = "Relation",
            titleText = "Select Relation",
            action = {
                binding.groupPurpose.visibility(it)
            }
        )
        setupButton()
    }

    @SuppressLint("SetTextI18n")
    private fun setupButton() {
        binding.btnContinue.apply {
            btnContinue.text = "Continue"
            btnContinue.setOnClickListener {
                val action =
                    PayToAnyonePayFragmentDirections.actionPayToAnyonePayFragmentToEnterAmountFragment(
                        args.payeeDetails,
                        accountData!!
                    )
                navigation(action)
            }
        }

    }

}