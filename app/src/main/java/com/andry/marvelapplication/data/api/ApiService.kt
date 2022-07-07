package com.andry.marvelapplication.data.api

import com.andry.marvelapplication.data.models.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @GET("comics")
    suspend fun getData(): Response<ApiResponse>
}