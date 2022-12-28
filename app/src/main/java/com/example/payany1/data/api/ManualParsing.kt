package com.example.payany1.data.api

import android.content.Context
import android.util.Log
import com.example.payany1.data.models.GetPayeeDetails
import com.example.payany1.data.models.PayeeList
import com.google.gson.Gson
import java.io.IOException

class ManualParsing : JsonAPIService {
    private val context: Context? = null
    var jsonDetailsString: String? = null
    var jsonListString: String? = null
    override suspend fun getPayeeList(): PayeeList {
        try {
            jsonListString =
                context!!.assets.open("PayeeList.json").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            Log.d("Exception", ioException.toString())
        }
        return Gson().fromJson(jsonListString, PayeeList::class.java)
    }

    override suspend fun getPayeeDetails(): GetPayeeDetails {
        try {
            jsonDetailsString =
                context!!.assets.open("GetPayeeDetails.json").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            Log.d("Exception", ioException.toString())
        }
        return Gson().fromJson(jsonDetailsString, GetPayeeDetails::class.java)
    }


}