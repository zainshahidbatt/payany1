package com.example.payany1.ui.components


import androidx.core.view.isVisible
import com.example.payany1.data.adapters.PurposeAdapter
import com.example.payany1.data.models.Purpose
import com.example.payany1.databinding.ComponentPurposeBinding
import com.example.payany1.utils.hide
import com.example.payany1.utils.visible

class PurposeComponent(
    private val binding: ComponentPurposeBinding,
    private val list: List<Purpose>,
    private val action: ((Boolean) -> Unit)? = null,
    text: String,
    titleText: String
) {
    private var purposeAdapter = PurposeAdapter()

    init {
        setupRecyclerView()
        showAndHideComponent()
        binding.txtPurpose.text = text
        binding.txtLabel.text = titleText
    }

    private fun showAndHideComponent() {
        binding.apply {
            cardView.setOnClickListener {
                action?.invoke(group4.isVisible)
                if (group3.isVisible) {
                    group3.hide()
                    group4.visible()
                } else {
                    group3.visible()
                    group4.hide()
                }
            }
        }
    }

    private fun setupRecyclerView() {
        binding.rvAccounts.apply {
            adapter = purposeAdapter
            purposeAdapter.accountData = list
            purposeAdapter.onItemClick = { accountData ->
                binding.apply {
                    txtLabel.text = accountData.purpose
                    group4.hide()
                    action?.invoke(true)
                    group3.visible()
                }
            }
        }
    }
}