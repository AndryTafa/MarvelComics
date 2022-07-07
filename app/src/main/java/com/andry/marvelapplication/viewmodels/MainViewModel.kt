package com.andry.marvelapplication.viewmodels

import android.app.Application
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.andry.marvelapplication.repos.ComicsRepo
import com.andry.marvelapplication.utils.EmptyObjects
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val TAG = this.javaClass.simpleName

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing = _isRefreshing.asStateFlow()

    private val _comics = MutableStateFlow(listOf(EmptyObjects.emptyComic()))
    val comics = _comics.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                _comics.value = ComicsRepo.getComicsFromDatabase(application.applicationContext)!!
            } catch (Ex: Exception) {
                Log.d(TAG, "Exception is ${Ex.localizedMessage?.toString()}")
            }
            _isLoading.value = false
        }
    }

    suspend fun refreshComic() {
        _isRefreshing.value = true
        try {
            withContext(Dispatchers.IO) {
                _comics.value = ComicsRepo.getComicsFromDatabase(getApplication<Application>().applicationContext)!!
            }
        } catch (Ex: Exception) {
            Log.d(TAG, "Exception is ${Ex.localizedMessage?.toString()}")
        } finally {
            _isRefreshing.value = false
        }
    }
}