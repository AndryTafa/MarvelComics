package com.andry.marvelapplication.repos

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.andry.marvelapplication.data.api.ApiService
import com.andry.marvelapplication.data.api.RetrofitClient
import com.andry.marvelapplication.data.models.*
import com.andry.marvelapplication.data.room.databases.AppDatabase
import com.andry.marvelapplication.utils.EmptyObjects
import kotlinx.coroutines.*

object ComicsRepo {
    private val TAG = ComicsRepo.javaClass.simpleName
    private val retrofit = RetrofitClient.getInstance()
    private val apiInterface = retrofit.create(ApiService::class.java)

    // API
    private suspend fun getApiResponse(): ApiResponse {
        var apiResultRepo = EmptyObjects.emptyApiResponse()
        try {
            val response = apiInterface.getData()
            if (response.isSuccessful && response.body() != null) {
                apiResultRepo = response.body()!!
            } else {
                Log.d(TAG, "Response not successful.")
            }
        } catch (Ex: Exception) {
            Ex.localizedMessage?.let { Log.e(TAG, it) }
        }
        return apiResultRepo
    }

    // Room
    suspend fun getComicsFromDatabase(context: Context?): List<Comic>? {
        val db = context?.let {
            Room.databaseBuilder(
                it,
                AppDatabase::class.java, "app_database"
            )
                .fallbackToDestructiveMigration() // I would only use this for development
                .build()
        }

        val comicDao = db?.comicDao()
        val apiResponse = getApiResponse()

        if (apiResponse.code == 200) {
            comicDao?.deleteAllComics()
            comicDao?.insertAll(apiResponse.data.comics)
        }

        val comicsFromDao = comicDao?.getAll()

        Log.d(TAG, "Comics from dao: $comicsFromDao")
        return comicDao?.getAll()
    }
}