package com.articles.remote.api

import com.articles.remote.model.ResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticlesService {
    @GET("everything")
    suspend fun getNewReleases(
        @Query("q") keyWords: String,
        @Query("from") from: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String
    ): ResponseWrapper
}