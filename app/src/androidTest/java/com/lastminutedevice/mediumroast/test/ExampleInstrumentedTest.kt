package com.lastminutedevice.mediumroast.test

import android.support.test.runner.AndroidJUnit4
import com.lastminutedevice.mediumroast.test.dsl.mainBot
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun counterIncrementsWhenPushed() {
        mainBot {
            userName = "MainBot"
            launch ()
        } next {
            clickButton()
        } verify {
            counterDisplays(1)
            userNameDisplayed("MainBot")
        } next {
            clickButton()
        } verify {
            counterDisplays(2)
        }
    }
}
