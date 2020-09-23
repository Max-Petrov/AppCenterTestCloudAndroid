package com.example.appcentertestcloudapp

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.appcentertestcloudapp.ui.MainActivity
import com.microsoft.appcenter.espresso.Factory
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TaskFeaturesTest {

    @get:Rule
    var reportHelper = Factory.getReportHelper()

    @get:Rule
    var activityScenarioRule =
        ActivityScenarioRule(
            MainActivity::class.java
        )

    @After
    fun TearDown() {
        reportHelper.label("Stopping App")
    }

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.appcentertestcloudapp", appContext.packageName)
    }

    @Test
    fun checkFiveTasksInList() {
        onView(withText("Test task 1")).check(matches(isDisplayed()))
        onView(withText("Test task 2")).check(matches(isDisplayed()))
        onView(withText("Test task 3")).check(matches(isDisplayed()))
        onView(withText("Test task 4")).check(matches(isDisplayed()))
        onView(withText("Test task 5")).check(matches(isDisplayed()))
    }

    @Test
    fun checkTaskDetailsForFirstItem() {
        onView(withText("Test task 1")).perform(click())
        onView(withId(R.id.taskNameEditText)).check(matches(withText("Test task 1")))
        onView(withId(R.id.taskDescriptionEditText)).check(matches(withText("Test description 1")))
        onView(withId(R.id.taskStatusCheckBox)).check(matches(isChecked()))
    }

    @Test
    fun editTaskDetailsAndUpdateList() {
        onView(withText("Test task 1")).perform(click())
        onView(withId(R.id.taskNameEditText)).perform(clearText())
        onView(withId(R.id.taskNameEditText)).perform(typeText("Updated test task"))
        onView(withId(R.id.saveButton)).perform(click())
        Espresso.pressBack()
        onView(withText("Updated test task")).check(matches(isDisplayed()))
    }
}
