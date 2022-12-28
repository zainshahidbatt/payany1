package com.example.payany1.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.payany1.data.models.PayeeData
import com.example.payany1.databinding.AccountListBinding
import com.example.payany1.ui.dashboard.DashBoardFragmentDirections
import com.example.payany1.utils.navigate

class PayeesAdapter : RecyclerView.Adapter<PayeesAdapter.PayeesViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<PayeeData>() {
        override fun areItemsTheSame(oldItem: PayeeData, newItem: PayeeData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PayeeData, newItem: PayeeData): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var payeeData: List<PayeeData>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PayeesViewHolder {
        val binding =
            AccountListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PayeesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return payeeData.size
    }

    override fun onBindViewHolder(holder: PayeesViewHolder, position: Int) {
        holder.bind(payeeData[position])
    }


    class PayeesViewHolder(private val binding: AccountListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PayeeData) {
            binding.apply {
                nameOfPerson.text = item.name
                accountNumber.text = item.accountNo.toString()
                bankName.text = item.bankName
                payeeImageView.setImageResource(item.image)

                cardView.setOnClickListener {
                    val action =
                        DashBoardFragmentDirections.actionDashBoardFragmentToPayeeDetailsFragment(
                            item
                        )
                    navigate(binding.root.findNavController(), action)
                }
            }
        }
    }
}