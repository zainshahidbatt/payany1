package com.example.payany1.data.api

import com.example.payany1.data.models.GetPayeeDetails
import com.example.payany1.data.models.PayeeList
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface PaymentAPIServices {

    @POST("GetPayDetails")
    suspend fun getPayeeDetails(@Body getPayeeDetails: GetPayeeDetails): Response<String>

    @POST("LoadPayeeList")
    suspend fun getPayeesList(@Body payeeList: PayeeList): Response<String>

}