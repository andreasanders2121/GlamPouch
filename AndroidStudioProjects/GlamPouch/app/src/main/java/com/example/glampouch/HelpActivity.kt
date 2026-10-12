package com.example.glampouch

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
        // Read-only screen: Displaying information only

        val btnBackToMain = findViewById<Button>(R.id.btnBackToMain)

        // Event listener: Return back to MainActivity
        btnBackToMain.setOnClickListener {
            finish() // Closes HelpActivity and reveals MainActivity underneath
        }
    }
}