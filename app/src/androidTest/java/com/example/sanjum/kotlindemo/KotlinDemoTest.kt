package com.example.sanjum.kotlindemo

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed


/**
 * Created by sanjum on 10/12/2017.
 */
@RunWith(AndroidJUnit4::class)
class KotlinDemoTest {
    @Rule
    @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun goToListScreenAndVerifyText() {
        onView(withId(R.id.btnNext)).perform(ViewActions.click())
        onView(withId(R.id.recyCler)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(13, click()))
        Thread.sleep(2000)

    }

    @Test
    fun verifyWelcomeMessage() {
        onView(withId(R.id.button_action)).perform(ViewActions.click())
        Thread.sleep(2000)
        allOf(withId(R.id.etText), withText(R.string.welcome_msg)).matches(isDisplayed())
        Thread.sleep(2000)
    }

    @Test
    fun clearWelcomeMessage() {
        onView(withId(R.id.button_action)).perform(ViewActions.click())
        allOf(withId(R.id.etText), withText(R.string.welcome_msg)).matches(isDisplayed())
        Thread.sleep(2000)
        onView(withId(R.id.button_action)).perform(click())
        Thread.sleep(2000)
        allOf(withId(R.id.etText), withText(R.string.welcome_msg)).matches(not(isDisplayed()))
        Thread.sleep(1000)

    }


}