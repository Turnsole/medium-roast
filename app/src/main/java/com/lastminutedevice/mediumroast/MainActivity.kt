package com.lastminutedevice.mediumroast

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

const val INTENT_KEY_USER_NAME = "user_name"

class MainActivity : AppCompatActivity() {

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        if (intent.hasExtra(INTENT_KEY_USER_NAME)) {
            val name = intent.getStringExtra(INTENT_KEY_USER_NAME)
            findViewById<TextView>(R.id.description).text = getString(R.string.description, name)
        }

        findViewById<View>(R.id.button).setOnClickListener {
            counter += 1
            findViewById<TextView>(R.id.counter).text = counter.toString()
        }
    }
}
