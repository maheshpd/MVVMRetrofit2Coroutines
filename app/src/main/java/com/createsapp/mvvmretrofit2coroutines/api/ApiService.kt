package com.createsapp.mvvmretrofit2coroutines.api

import com.createsapp.mvvmretrofit2coroutines.models.Employee
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getEmployee(): ArrayList<Employee>

}