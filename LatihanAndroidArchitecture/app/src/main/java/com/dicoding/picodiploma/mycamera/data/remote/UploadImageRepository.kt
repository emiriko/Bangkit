package com.dicoding.picodiploma.mycamera.data.remote

import com.dicoding.picodiploma.mycamera.data.remote.api.ApiService
import java.io.File

class UploadImageRepository private constructor(
    private val apiService: ApiService
){
    companion object {
        @Volatile
        private var instance: UploadImageRepository? = null
        fun getInstance(
            apiService: ApiService
        ): UploadImageRepository = instance ?: synchronized(this) {
            instance ?: UploadImageRepository(apiService)
        }.also { 
            instance = it
        }
    }
}