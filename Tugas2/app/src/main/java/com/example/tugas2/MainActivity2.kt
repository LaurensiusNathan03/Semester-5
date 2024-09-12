package com.example.tugas2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private lateinit var resultAct2 : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        resultAct2 = findViewById(R.id.resultAct2)
        enableEdgeToEdge()

        resultAct2.text = intent.getDoubleExtra("result",0.0).toString()

    }
}