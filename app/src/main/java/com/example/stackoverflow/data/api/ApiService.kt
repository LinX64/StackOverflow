package com.example.stackoverflow.data.api

import com.example.stackoverflow.data.model.QuestionsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("questions?")
    suspend fun getQuestions(
        @Query("order") order: String,
        @Query("sort") sort: String,
        @Query("tagged") tagged: String,
        @Query("site") site: String
    ): QuestionsResponse
}