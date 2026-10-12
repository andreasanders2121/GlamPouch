package com.example.glampouch

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etProductName = findViewById<EditText>(R.id.etProductName)
        val btnGoToSecondary = findViewById<Button>(R.id.btnGoToSecondary)
        val btnGoToPreferences = findViewById<Button>(R.id.btnGoToPreferences)
        val btnGoToHelp = findViewById<Button>(R.id.btnGoToHelp)

        // Event 1: Go to Secondary Activity (Passing Product Name Intent)
        btnGoToSecondary.setOnClickListener {
            val inputText = etProductName.text.toString()
            val intent = Intent(this, SecondaryActivity::class.java)
            intent.putExtra("EXTRA_PRODUCT_NAME", inputText)
            startActivity(intent)
        }

        // Event 2: Go to Preferences Activity Intent
        btnGoToPreferences.setOnClickListener {
            val intent = Intent(this, PreferencesActivity::class.java)
            startActivity(intent)
        }

        // Event 3: Go to Help Activity Intent
        btnGoToHelp.setOnClickListener {
            val intent = Intent(this, HelpActivity::class.java)
            startActivity(intent)
        }
    }
}