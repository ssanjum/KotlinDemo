package com.example.sanjum.kotlindemo

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.*
import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.contrib.RecyclerViewActions.*
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.example.sanjum.kotlindemo.helper.AppHelper
import org.hamcrest.Matchers.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by sanjum on 10/16/2017.
 */
@RunWith(AndroidJUnit4::class)
class KotlinTest {
    @Rule
    @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java)
    @Before
    fun before() {

        Thread.sleep(1000)
    }

    @Test
    fun goToMovieList() {
        onView(withId(R.id.btnNext)).perform(click())
        allOf(withId(R.id.recyCler)).matches(isDisplayed())
        Thread.sleep(2000)
    }

    @Test
    fun verifyAndClearWelcomeMessage() {
        onView(withId(R.id.button_action)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.etText)).check(matches(withText(R.string.welcome_msg)))
        Thread.sleep(1000)
        onView(withId(R.id.button_action)).perform(click())
        onView(withId(R.id.etText)).check(matches(withText("")))
        Thread.sleep(2000)
    }


    @Test
    fun verifyMovieName() {
        onView(withId(R.id.btnNext)).perform(click())
        allOf(withId(R.id.recyCler)).matches(isDisplayed())
        Thread.sleep(500)
        onView(withId(R.id.recyCler)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))
        Thread.sleep(2000)
       onView(withId(R.id.fr_title)).check(matches(withText("Inside Out")))
        Thread.sleep(2000)
    }

    @Test
    fun clickOnTabs() {
        onView(withId(R.id.btnNext)).perform(click())
        allOf(withId(R.id.recyCler)).matches(isDisplayed())
        Thread.sleep(500)
        onView(withId(R.id.recyCler)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(11, click()))
        onView(withId(R.id.pager)).perform(swipeLeft())
       // onView(withText("Info")).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.pager)).perform(swipeRight())
       // onView(withText("Movie")).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.pager)).perform(swipeLeft())
       // onView(withText("Info")).perform(click())
        Thread.sleep(500)
        onView(withId(R.id.fr_dimage_button)).check(matches(isDisplayed()))
        onView(withId(R.id.fr_dimage_button)).perform(click())
        Thread.sleep(2000)
    }
    @Test
    fun swappingRecycler() {
        onView(withId(R.id.btnNext)).perform(click())
        allOf(withId(R.id.recyCler)).matches(isDisplayed())
        Thread.sleep(2000)
        onView(withId(R.id.recyCler)).perform(swipeUp())
        Thread.sleep(1000)
        onView(withId(R.id.recyCler)).perform(swipeDown())
        Thread.sleep(1000)
        onView(withId(R.id.recyCler)).perform(swipeUp())
        Thread.sleep(1000)
        onView(withId(R.id.recyCler)).perform(swipeDown())
        Thread.sleep(1000)
    }

}