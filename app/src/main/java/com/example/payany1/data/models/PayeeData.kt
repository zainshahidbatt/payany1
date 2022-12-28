package com.example.payany1.data.models

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize


@Parcelize
data class PayeeData(
    val name: String,
    val accountNo: Long,
    val bankName: String,
    @DrawableRes val image: Int
) : Parcelable