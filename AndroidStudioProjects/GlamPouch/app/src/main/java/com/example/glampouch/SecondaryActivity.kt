package com.example.glampouch

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        val tvReceivedData = findViewById<TextView>(R.id.tvReceivedData)

        // Read the sticky note passed from MainActivity
        val receivedName = intent.getStringExtra("EXTRA_PRODUCT_NAME")

        if (!receivedName.isNullOrEmpty()) {
            tvReceivedData.text = "Now logging to inventory: $receivedName"
        } else {
            tvReceivedData.text = "No product name provided."

            // Event: Return back to MainActivity
            val btnBackFromSecondary = findViewById<Button>(R.id.btnBackFromSecondary)
            btnBackFromSecondary.setOnClickListener {
                finish()
            }
        }
    }
}