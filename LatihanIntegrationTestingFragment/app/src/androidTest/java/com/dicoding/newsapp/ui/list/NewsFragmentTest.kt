package com.dicoding.newsapp.ui.list

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dicoding.newsapp.JsonConverter
import com.dicoding.newsapp.R
import com.dicoding.newsapp.data.remote.retrofit.ApiConfig
import com.dicoding.newsapp.utils.EspressoIdlingResource
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NewsFragmentTest {

    private val mockWebServer = MockWebServer()

    @Before
    fun setUp() {
        mockWebServer.start(8080)
        ApiConfig.BASE_URL = "http://127.0.0.1:8080/"
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }
    
    @After
    fun tearDown() {
        mockWebServer.shutdown()
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
    }

    @Test
    fun getHeadlineNews_Success() {
        val bundle = Bundle()
        bundle.putString(NewsFragment.ARG_TAB, NewsFragment.TAB_NEWS)
        launchFragmentInContainer <NewsFragment>(bundle, R.style.Theme_News)
        //check data is match

        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(JsonConverter.readStringFromFile("success_response.json"))
        mockWebServer.enqueue(mockResponse)

        Espresso.onView(ViewMatchers.withId(R.id.rv_news))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText("Inti Bumi Mendingin Lebih Cepat, Pertanda Apa? - detikInet"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rv_news))
            .perform(
                RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                    ViewMatchers.hasDescendant(ViewMatchers.withText("Perjalanan Luar Angkasa Sebabkan Anemia - CNN Indonesia"))
                )
            )
        
    }

    @Test
    fun getHeadlineNews_Error() {
        val bundle = Bundle()
        bundle.putString(NewsFragment.ARG_TAB, NewsFragment.TAB_NEWS)
        launchFragmentInContainer<NewsFragment>(bundle, R.style.Theme_News)
        val mockResponse = MockResponse()
            .setResponseCode(500)
        mockWebServer.enqueue(mockResponse)
        Espresso.onView(ViewMatchers.withId(R.id.tv_error))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText("Oops.. something went wrong."))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}