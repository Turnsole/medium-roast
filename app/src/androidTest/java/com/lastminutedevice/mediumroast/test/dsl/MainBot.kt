package com.lastminutedevice.mediumroast.test.dsl

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import com.lastminutedevice.mediumroast.INTENT_KEY_USER_NAME
import com.lastminutedevice.mediumroast.MainActivity
import com.lastminutedevice.mediumroast.R
import org.junit.Rule

fun mainBot(function: MainBot.() -> Unit) = MainBot().apply { function() }

/**
 * This contains all the instrumentation code necessary to test the Main Activity.
 */
class MainBot : BaseBot() {

    var userName: String? = null

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    /**
     * Launches MainActivity.
     * This needs to get called _after_ any pre-launch vars are set.
     */
    fun launch() {
        val intent = Intent()
        intent.putExtra(INTENT_KEY_USER_NAME, userName)
        activityTestRule.launchActivity(intent)
    }

    infix fun next(block: MainActions.() -> Unit) : MainBot {
        MainActions().block()
        return this
    }

    class MainActions {
        fun clickButton() {
            Espresso.onView(ViewMatchers.withId(R.id.button)).perform(ViewActions.click())
        }
    }

    infix fun verify(block: MainAssertions.() -> Unit) : MainBot {
        MainAssertions().block()
        return this
    }

    class MainAssertions {

        fun counterDisplays(count: Int) {
            Espresso.onView(ViewMatchers.withId(R.id.counter)).check(ViewAssertions.matches(ViewMatchers.withText(count.toString())))
        }

        fun userNameDisplayed(name: String) {
            val text = InstrumentationRegistry.getTargetContext().getString(R.string.description, name)
            Espresso.onView(ViewMatchers.withId(R.id.description)).check(ViewAssertions.matches(ViewMatchers.withText(text)))
        }
    }
}
