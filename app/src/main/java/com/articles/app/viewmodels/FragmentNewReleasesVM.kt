package com.articles.app.viewmodels

import com.articles.BuildConfig
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.articles.app.utils.Resource
import com.articles.remote.model.Article
import com.articles.source.RemoteDataSource
import kotlinx.coroutines.launch
import javax.inject.Inject

class FragmentNewReleasesVM @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : ViewModel() {

    private val newReleasesList = MutableLiveData<Resource<List<Article>>>()
    val newReleases: LiveData<Resource<List<Article>>>
        get() = newReleasesList

    init {
        newReleasesList.postValue(Resource.loading())
        viewModelScope.launch {
            try {
                newReleasesList.postValue(
                    Resource.success(remoteDataSource
                        .getNewReleases(
                            BuildConfig.KEYWORDS,
                            BuildConfig.FROM,
                            BuildConfig.SORTBY,
                            BuildConfig.API_KEY
                        ).articles
                    )
                )
            } catch (e: Throwable) {
                newReleasesList.postValue(Resource.error(e.localizedMessage))
            }
        }
    }
}