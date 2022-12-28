package com.example.payany1.ui.components

import android.annotation.SuppressLint
import androidx.core.view.isVisible
import com.example.payany1.data.adapters.AccountSelectAdapter
import com.example.payany1.data.models.AccountData
import com.example.payany1.databinding.SelectAccountComponentBinding
import com.example.payany1.utils.hide
import com.example.payany1.utils.visible


class AccountSelectionComponent(
    private val binding:SelectAccountComponentBinding,
    private val list: List<AccountData>,
    private val currentAccount: (AccountData) -> Unit,
    private val action: ((Boolean) -> Unit)? = null
) {
    private var accountAdapter = AccountSelectAdapter()
    private var lastItem = list[0].holderName

    init {
        setupRecyclerView()
        setupSelectedData(list[0])
        currentAccount.invoke(list[0])
        showAndHideComponent()
    }

    @SuppressLint("SetTextI18n")
    private fun showAndHideComponent() {
        binding.apply {
            cardView.setOnClickListener {
                action?.invoke(group2.isVisible)
                if (group.isVisible) {
                    group.hide()
                    group2.visible()
                    tvUserName.text = "Select Account"

                } else {
                    tvUserName.text = lastItem
                    group.visible()
                    group2.hide()
                }
            }
        }
    }

    private fun setupRecyclerView() {
        binding.rvAccounts.apply {
            adapter = accountAdapter
            accountAdapter.accountData = list
            accountAdapter.onItemClick = { accountData ->

                binding.apply {
                    tvUserName.text = accountData.holderName
                    accountNumber.text = accountData.accountNumber.toString()
                    group2.hide()
                    action?.invoke(true)
                    group.visible()
                    lastItem = accountData.holderName
                    currentAccount.invoke(accountData)
                }
            }
        }
    }

    private fun setupSelectedData(accountData: AccountData) {
        binding.apply {
            tvUserName.text = accountData.holderName
            accountNumber.text = accountData.accountNumber.toString()
        }
    }
}