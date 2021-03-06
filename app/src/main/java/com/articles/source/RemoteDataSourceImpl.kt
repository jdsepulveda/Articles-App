package com.articles.source

import com.articles.remote.api.ArticlesService
import com.articles.remote.model.ResponseWrapper
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val articlesService: ArticlesService
) : RemoteDataSource {

    override suspend fun getNewReleases(
        keyWords: String,
        from: String,
        sortBy: String,
        apiKey: String
    ): ResponseWrapper {
        return articlesService.getNewReleases(keyWords, from, sortBy, apiKey)
    }
}