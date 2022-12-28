package com.example.payany1.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.payany1.base.BaseFragment
import com.example.payany1.data.adapters.PayeesAdapter
import com.example.payany1.databinding.FragmentDashBoardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashBoardFragment : BaseFragment<FragmentDashBoardBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDashBoardBinding =
        FragmentDashBoardBinding::inflate

    private val groupsAdapter = PayeesAdapter()
    private val viewModel by viewModels<DashBoardVM>()

    override fun onCreatedView() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            adapter = groupsAdapter
            groupsAdapter.payeeData = viewModel.data
        }
    }

}