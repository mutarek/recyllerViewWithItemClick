package com.example.recyllerviewbatch2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    lateinit var gtv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        gtv = findViewById(R.id.sampletet)
        getIntentData()
    }

    private fun getIntentData() {
        gtv.text = intent.getStringExtra("name")
        intent.getStringExtra("number")
        intent.getStringExtra("profile")
    }
}