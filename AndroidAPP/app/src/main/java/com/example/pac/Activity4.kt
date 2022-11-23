package com.example.pac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activity4 : AppCompatActivity() {

    lateinit var btnActivity1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity4)

        btnActivity1 = findViewById(R.id.btnActivity)

        btnActivity1.setOnClickListener{
            val goToActivity1 = Intent(this, MainActivity::class.java)
            startActivity(goToActivity1)
        }
    }
}