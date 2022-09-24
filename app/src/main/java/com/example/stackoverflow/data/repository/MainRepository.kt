package com.example.stackoverflow.data.repository

import com.example.stackoverflow.data.api.ApiService
import com.example.stackoverflow.util.NetworkResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getQuestions() = flow {
        emit(NetworkResult.Loading(true))

        val response = apiService.getQuestions(
            "desc",
            "activity",
            "android",
            "stackoverflow"
        )
        emit(NetworkResult.Success(response.items))
    }.catch { e -> emit(NetworkResult.Error(e.message.toString())) }
}