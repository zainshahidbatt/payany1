package com.example.payany1.data.repo

import com.example.payany1.data.api.JsonAPIService
import com.example.payany1.data.models.GetPayeeDetails
import com.example.payany1.data.models.PayeeList
import javax.inject.Inject

class DataRepository @Inject constructor(private val apiService: JsonAPIService) {

    suspend fun getPayeeList(): PayeeList {
        return apiService.getPayeeList()
    }

    suspend fun getPayeeDetails(): List<GetPayeeDetails.GnbPayAnyOne> {
        return apiService.getPayeeDetails().outDTDataset.gnbPayAnyOneList
    }
}