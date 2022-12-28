package com.example.payany1.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AccountData(
    val holderName: String,
    val accountNumber: Long,
    val amount: Long
) : Parcelable