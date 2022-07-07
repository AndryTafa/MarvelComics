package com.andry.marvelapplication.data.api

import com.andry.marvelapplication.utils.AppConstants
import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter("apikey", AppConstants.PUBLIC_API_KEY)
            .addQueryParameter("hash", AppConstants.API_HASH)
            .addQueryParameter("ts", AppConstants.TIMESTAMP.toString())
            .build()
        request = request.newBuilder().url(url).build();
        return chain.proceed(request)
    }
}