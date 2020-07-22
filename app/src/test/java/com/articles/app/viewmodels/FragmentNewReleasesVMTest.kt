package com.articles.app.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.articles.app.utils.Resource
import com.articles.remote.model.Article
import com.articles.source.RemoteDataSource
import com.articles.utils.TestArticlesGenerator.Companion.generateResponseWrapperOK
import com.articles.utils.TestCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class FragmentNewReleasesVMTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var remoteDataSource: RemoteDataSource

    @Mock
    private lateinit var newReleasesList: Observer<Resource<List<Article>>>

    private lateinit var fragmentNewReleasesVM: FragmentNewReleasesVM

    private val mockResponse = generateResponseWrapperOK()

    @Test
    fun test_getNewReleases_success() {
        testCoroutineRule.runBlockingTest {
            doReturn(mockResponse)
                .`when`(remoteDataSource)
                .getNewReleases(anyString(), anyString(), anyString(), anyString())

            fragmentNewReleasesVM = FragmentNewReleasesVM(remoteDataSource)

            fragmentNewReleasesVM.newReleases.observeForever(newReleasesList)

            verify(remoteDataSource).getNewReleases(anyString(), anyString(), anyString(), anyString())

            verify(newReleasesList).onChanged(Resource.success(mockResponse.articles))

            fragmentNewReleasesVM.newReleases.removeObserver(newReleasesList)
        }
    }

    @Test
    fun test_getNewReleases_error() {
        testCoroutineRule.runBlockingTest {
            val errorMsg = "Error"
            doThrow(RuntimeException(errorMsg))
                .`when`(remoteDataSource)
                .getNewReleases(anyString(), anyString(), anyString(), anyString())

            fragmentNewReleasesVM = FragmentNewReleasesVM(remoteDataSource)

            fragmentNewReleasesVM.newReleases.observeForever(newReleasesList)

            verify(remoteDataSource).getNewReleases(anyString(), anyString(), anyString(), anyString())

            verify(newReleasesList).onChanged(Resource.error(errorMsg, null))

            fragmentNewReleasesVM.newReleases.removeObserver(newReleasesList)
        }
    }
}