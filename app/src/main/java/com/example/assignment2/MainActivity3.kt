package com.example.assignment2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val scoreText = findViewById<TextView>(R.id.scoreText)
        val feedbackText = findViewById<TextView>(R.id.feedbackText)
        val reviewBtn = findViewById<Button>(R.id.reviewBtn)

// Get score from MainActivity2
        val score = intent.getIntExtra("score", 0)

// Display score
        scoreText.text = "Your Score: $score / 5"

// Feedback logic
        feedbackText.text = when {
            score >= 4 -> "🔥 Master Hacker!"
            score >= 2 -> "👍 Good Effort!"
            else -> "⚠️ Stay Safe Online!"
        }

// REVIEW button → go back to quiz screen
        reviewBtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
    }
}

