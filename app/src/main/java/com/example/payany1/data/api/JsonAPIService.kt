package com.example.payany1.data.api

import com.example.payany1.data.models.GetPayeeDetails
import com.example.payany1.data.models.PayeeList

interface JsonAPIService {
   suspend fun getPayeeList():PayeeList

   suspend fun getPayeeDetails():GetPayeeDetails
}