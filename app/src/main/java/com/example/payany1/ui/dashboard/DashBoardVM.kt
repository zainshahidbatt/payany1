package com.example.payany1.ui.dashboard

import androidx.lifecycle.ViewModel
import com.example.payany1.R
import com.example.payany1.data.models.AccountData
import com.example.payany1.data.models.PayeeData
import com.example.payany1.data.models.Purpose


class DashBoardVM : ViewModel() {
    val data: MutableList<PayeeData> =
        mutableListOf(
            PayeeData("Laiba Riaz", 123456789, "Ubl", R.drawable.ic_profile),
            PayeeData("Haroon Qamar", 988978778, "Ubl", R.drawable.ic_profile),
            PayeeData("Aawais Umer", 123456789, "Ubl", R.drawable.ic_profile),
            PayeeData("Ahmad Shahid", 123456789, "Ubl", R.drawable.ic_profile),
            PayeeData ("Isha Kiyani", 988978778, "Ubl", R.drawable.ic_profile),
            PayeeData("Izza Rehman", 123456789, "Ubl", R.drawable.ic_profile),
            PayeeData("Asad Sattar", 123456789, "Ubl", R.drawable.ic_profile)

    )

    val accountList: MutableList<AccountData> =
        mutableListOf(
            AccountData("Laiba Riaz", 123456789, 1000),
            AccountData("Haroon Qamar", 12345678910, 20000),
            AccountData("Awais Umer", 12345678911, 300000),
            AccountData("Ahmad Shahid", 12345678, 400000),
            AccountData("Zaib ALi", 123456789, 5000),

            )

    val purposeList: MutableList<Purpose> =
        mutableListOf(
            Purpose("charity"),
            Purpose("Government"),
            Purpose("Investments"),
            Purpose("Leisure"),
            Purpose("Loans"),
            Purpose("Personal"),
            Purpose("Rental"),
        )

    val relationList: MutableList<Purpose> =
        mutableListOf(
            Purpose("Corporate Card Payment"),
            Purpose("Credit card Payment")
        )

}