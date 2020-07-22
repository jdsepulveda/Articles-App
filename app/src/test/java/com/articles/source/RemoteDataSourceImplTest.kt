package com.articles.source

import com.articles.remote.api.ArticlesService
import com.articles.utils.TestArticlesGenerator
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.core.IsEqual
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class RemoteDataSourceImplTest {

    @Mock
    private lateinit var articlesService: ArticlesService

    private lateinit var remoteDataSource: RemoteDataSource

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        remoteDataSource = RemoteDataSourceImpl(articlesService)
    }

    @Test
    fun test_getNewReleases_success() = runBlockingTest {
        val mockResponse = TestArticlesGenerator.generateResponseWrapperOK()

        Mockito.`when`(
            articlesService.getNewReleases(anyString(), anyString(), anyString(), anyString())
        ).thenReturn(mockResponse)

        val newReleases = remoteDataSource
            .getNewReleases(anyString(), anyString(), anyString(), anyString())

        assertThat(mockResponse.articles, IsEqual(newReleases.articles))
    }
}