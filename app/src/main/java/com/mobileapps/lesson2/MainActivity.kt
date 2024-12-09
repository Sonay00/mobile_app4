package com.mobileapps.lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getStartedButton = findViewById<Button>(R.id.getStartedButton)

        getStartedButton.setOnClickListener {
            navigateToAccountActivity()
        }
    }

    private fun navigateToAccountActivity() {
        val intent = Intent(this, AccountActivity::class.java)
        startActivity(intent)
    }
}
