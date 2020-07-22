package com.articles.app.ui

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.runner.RunWith
import com.articles.R
import org.junit.Test

@RunWith(AndroidJUnit4ClassRunner::class)
class FragmentNewReleasesTest {

    @Test
    fun test_right_title_list_articles_displayed() {
        launchFragmentInContainer<FragmentNewReleases>()
        onView(withId(R.id.TitleNewReleases)).check(matches(withText("Parutions récentes")))
    }
}