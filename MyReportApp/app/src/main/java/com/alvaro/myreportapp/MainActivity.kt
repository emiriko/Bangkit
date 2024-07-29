package com.alvaro.myreportapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.d("Test debugging")
        
        val btnCrash = findViewById<Button>(R.id.btn_crash)
        btnCrash.setOnClickListener {
            try {
                FirebaseCrashlytics.getInstance().log("Clicked on button")
                FirebaseCrashlytics.getInstance().setCustomKey("str_key", "some_data")
                throw RuntimeException("Test Crash")
            } catch (e: Exception) {
                Timber.e("Test non fatal exception")
            }
        }
    }
}