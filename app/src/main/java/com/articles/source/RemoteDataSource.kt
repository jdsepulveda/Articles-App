package com.articles.source

import com.articles.remote.model.ResponseWrapper

interface RemoteDataSource {

    suspend fun getNewReleases(
        keyWords: String,
        from: String,
        sortBy: String,
        apiKey: String
    ): ResponseWrapper
}