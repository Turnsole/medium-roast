package com.lastminutedevice.mediumroast

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.button).setOnClickListener {
            incrementCounter()
        }
    }

    private fun incrementCounter() {
        counter += 1
        findViewById<TextView>(R.id.counter).text = counter.toString()
    }
}
