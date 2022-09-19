package com.example.stackoverflow.data.api

import com.example.stackoverflow.data.model.QuestionsResponse
import retrofit2.http.GET

interface ApiService {

    @GET("questions?order=desc&sort=activity&tagged=android&site=stackoverflow")
    suspend fun getQuestions(): QuestionsResponse
}