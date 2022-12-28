package com.example.payany1.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetPayeeDetails(
    @SerializedName("Response") val response: String?,
    @SerializedName("strReturnMessage") val strReturnMessage: String?,
    @SerializedName("outdtData") val outDTData: String,
    @SerializedName("outdtDataset") val outDTDataset: OutDTDataset,
    @SerializedName("strhCode") val hCode: String
) : Parcelable {

    @Parcelize
    data class OutDTDataset(
        @SerializedName("GnbPayAnyOneList") val gnbPayAnyOneList: List<GnbPayAnyOne>
    ) : Parcelable

    @Parcelize
    data class GnbPayAnyOne(
        @SerializedName("ACCOUNT_NAME") var _accountName: String?,
        @SerializedName("ACCOUNT_NO") val accountNo: String,
        @SerializedName("BANK_CODE") val bankCode: String,
        @SerializedName("BRANCH_CODE") val branchCode: String?,
        @SerializedName("CDG_CODE") val cdgCode: String?,
        @SerializedName("TT_ACCESS_KEY") val ttAccessKey: String,
        @SerializedName("TYPE") val type: String,
        @SerializedName("USER_ACCOUNT_ID") val userAccountId: String,
        @SerializedName("IS_FAVOURITE") var isFavourite: String?,
        var isFavouritePayee: Boolean = false
    ) : Parcelable {
        val accountName get() = _accountName ?: ""

        val isFundsToCnic get() = type == "Transfer Funds to CNIC"
        val isFundsToRaast get() = type == "Raast Fund Transfer"
        val isDirectDeposit get() = type == "Direct Deposit"

    }
}