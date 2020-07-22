package com.articles.remote.model

import com.google.gson.annotations.SerializedName

data class ResponseWrapper(
    @SerializedName("status") val status: String,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("articles") val articles: List<Article>
)