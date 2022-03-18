package com.edumath.mathquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SingleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.MathTest)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)
    }
}