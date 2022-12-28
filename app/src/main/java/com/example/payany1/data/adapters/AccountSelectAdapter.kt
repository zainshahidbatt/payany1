package com.example.payany1.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.payany1.data.models.AccountData
import com.example.payany1.databinding.ItemAccountsBinding

class AccountSelectAdapter : RecyclerView.Adapter<AccountSelectAdapter.AccountViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<AccountData>() {
        override fun areItemsTheSame(oldItem: AccountData, newItem: AccountData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: AccountData, newItem: AccountData): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var accountData: List<AccountData>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val binding =
            ItemAccountsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AccountViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return accountData.size
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        holder.bind(accountData[position])
    }

    var onItemClick: ((AccountData) -> Unit)? = null

    inner class AccountViewHolder(private val binding: ItemAccountsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: AccountData) {
            binding.apply {
                tvPersonName.text = item.holderName
                tvAccountNo.text = item.accountNumber.toString()
                tvAmount.text = item.amount.toString()

                cardView.setOnClickListener {
                    onItemClick?.invoke(item)
                }
            }
        }
    }
}