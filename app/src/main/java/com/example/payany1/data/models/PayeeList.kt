package com.example.payany1.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class PayeeList(
    @SerializedName("Response") val response: String? = "",
    @SerializedName("strReturnMessage") val strReturnMessage: String? = "",
    @SerializedName("outdtData") val outDtData: String? = "",
    @SerializedName("outdtDataset") val outDtDataset: OutDtDataset,
    @SerializedName("outdsIBFTRelation") val outDsIBFTRelation: OutDsIBFTRelation? = null,
    @SerializedName("outStrIBFTRelation") val outStrIBFTRelation: String? = "",
    @SerializedName("outdsIBFTPOT") val outDsPOTiBFT: DsPOTiBFT? = null
) : Parcelable {

    @Parcelize
    data class DsPOTiBFT(
        @SerializedName("Table") val tableOne: List<TableOne>?
    ) : Parcelable

    @Parcelize
    data class OutDsIBFTRelation(
        @SerializedName("Table") val tableTwo: List<TableTwo>?
    ) : Parcelable

    @Parcelize
    data class OutDtDataset(
        @SerializedName("PayeePayDetail") val payeeDetails: List<PayeeDetail>
    ) : Parcelable

    @Parcelize
    data class TableOne(
        @SerializedName("IBFT_POT_ID") val potIdIBFT: String,
        @SerializedName("IBFT_POT_DESC") val potDescIBFT: String,
        @SerializedName("CNIC_POT_ID") val potIdCNIC: String,
        @SerializedName("CNIC_POT_DESC") val potDescCNIC: String
    ) : Parcelable

    @Parcelize
    data class TableTwo(
        @SerializedName("IBFT_RELATION_ID") val relationIdIBFT: String,
        @SerializedName("IBFT_RELATION_DESC") val relationDescIBFT: String
    ) : Parcelable

    @Parcelize
    data class PayeeDetail(
        @SerializedName("USER_ACCOUNT_ID") val userAccountId: String,
        @SerializedName("ACCOUNT_NO") val accountNumber: String,
        @SerializedName("ACCOUNT_NAME") val accountName: String,
        @SerializedName("TT_NAME") val ttName: String,
        @SerializedName("BANK_NAME") val bankName: String,
        @SerializedName("BANK_IMD") val bankIMD: String,
        @SerializedName("EMAIL") val _email: String?,
        @SerializedName("BENEFICIARYMOBILE") val _beneficiaryMobile: String?
    ) : Parcelable {
        val email get() = _email ?: String()
        val beneficiaryMobile get() = _beneficiaryMobile ?: String()
    }
}
