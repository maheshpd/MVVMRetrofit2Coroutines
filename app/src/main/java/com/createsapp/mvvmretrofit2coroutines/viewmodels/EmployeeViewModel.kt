package com.createsapp.mvvmretrofit2coroutines.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.createsapp.mvvmretrofit2coroutines.api.ApiClient
import com.createsapp.mvvmretrofit2coroutines.utils.ApiResponse
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class EmployeeViewModel(): ViewModel() {

    fun getEmployee() = liveData(Dispatchers.IO) {
        emit(ApiResponse.loading(data = null))

        try {
            emit(ApiResponse.success(data = ApiClient.apiService.getEmployee()))
        } catch (exception: Exception){
            emit(ApiResponse.error(data = null, message = exception.message?:"Error Occurred!"))
        }
    }
}