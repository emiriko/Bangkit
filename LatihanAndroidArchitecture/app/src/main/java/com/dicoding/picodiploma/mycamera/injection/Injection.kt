package com.dicoding.picodiploma.mycamera.injection

import android.content.Context
import com.dicoding.picodiploma.mycamera.data.remote.UploadImageRepository
import com.dicoding.picodiploma.mycamera.data.remote.api.ApiConfig

object Injection {
    fun provideRepository(context: Context): UploadImageRepository {
        val apiService = ApiConfig.getApiService()
        return UploadImageRepository.getInstance(apiService)
    }
}