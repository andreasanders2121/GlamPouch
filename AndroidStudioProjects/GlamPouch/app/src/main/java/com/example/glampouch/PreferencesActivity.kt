package com.example.glampouch

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PreferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)

        val etDefaultBrand = findViewById<EditText>(R.id.etDefaultBrand)
        val switchExpiryAlerts = findViewById<Switch>(R.id.switchExpiryAlerts)
        val btnSavePreferences = findViewById<Button>(R.id.btnSavePreferences)
        val tvSavedStatus = findViewById<TextView>(R.id.tvSavedStatus)

        val sharedPref = getSharedPreferences("GlamPouchPrefs", Context.MODE_PRIVATE)

        // Load saved preferences (or set default values)
        val savedBrand = sharedPref.getString("KEY_BRAND", "Andrea Marie Cosmetics")
        val savedAlerts = sharedPref.getBoolean("KEY_ALERTS", true)

        etDefaultBrand.setText(savedBrand)
        switchExpiryAlerts.isChecked = savedAlerts

        // Save preferences when button is clicked
        btnSavePreferences.setOnClickListener {
            val editor = sharedPref.edit()
            editor.putString("KEY_BRAND", etDefaultBrand.text.toString())
            editor.putBoolean("KEY_ALERTS", switchExpiryAlerts.isChecked)
            editor.apply()

            tvSavedStatus.text = "Preferences saved successfully!"
        }

        // Event 2: Return back to MainActivity
        val btnBackFromPreferences = findViewById<Button>(R.id.btnBackFromPreferences)
        btnBackFromPreferences.setOnClickListener {
            finish()
        }
    }
}