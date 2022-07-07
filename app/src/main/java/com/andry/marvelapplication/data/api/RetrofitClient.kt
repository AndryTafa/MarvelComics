package com.andry.marvelapplication.data.api

import com.andry.marvelapplication.utils.AppConstants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    fun getInstance(): Retrofit {
        val mOkHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(CustomInterceptor())
        }.build()

        return Retrofit.Builder()
            .baseUrl(AppConstants.API_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

