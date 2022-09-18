package com.example.stackoverflow.data.repository

import com.example.stackoverflow.data.api.ApiService
import com.example.stackoverflow.util.NetworkResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getQuestions() = flow {
        val response = apiService.getQuestions()
        emit(NetworkResult.Success(response.items))
    }
}