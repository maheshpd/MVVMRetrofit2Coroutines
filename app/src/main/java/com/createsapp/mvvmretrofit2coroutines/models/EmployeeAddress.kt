package com.createsapp.mvvmretrofit2coroutines.models

import com.google.gson.annotations.SerializedName

data class EmployeeAddress(

    @SerializedName("street")
    val employeeStreet: String? = null,

    @SerializedName("suite")
    val employeeSuite: String? = null,

    @SerializedName("city")
    val employeeCity: String? = null,

    @SerializedName("zipcode")
    val employeeZipCode: String? = null
)
