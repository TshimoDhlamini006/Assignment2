package com.example.assignment2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var questionText: TextView
    private lateinit var resultText: TextView

    private val questions = arrayOf(
        "Drinking water improves concentration",
        "Sleeping 2 hours is enough",
        "Exercise improves mood",
        "Skipping meals helps weight loss",
        "Reading daily improves knowledge"
    )

    private val answers = arrayOf(
        true,
        false,
        true,
        false,
        true
    )

    private var currentIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

// connect XML IDs
        questionText = findViewById(R.id.questionText)
        resultText = findViewById(R.id.resultText)

        val hackBtn = findViewById<Button>(R.id.hackBtn)
        val mythBtn = findViewById<Button>(R.id.mythBtn)
        val nextBtn = findViewById<Button>(R.id.nextBtn)

// show first question
        showQuestion()

// TRUE button
        hackBtn.setOnClickListener {
            checkAnswer(true)
        }

// FALSE button
        mythBtn.setOnClickListener {
            checkAnswer(false)
        }

// NEXT button
        nextBtn.setOnClickListener {
            goToNextQuestion()
        }
    }

    private fun showQuestion() {
        questionText.text = questions[currentIndex]
        resultText.text = ""
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == answers[currentIndex]) {
            score++
            resultText.text = "Correct!"
        } else {
            resultText.text = "Wrong!"
        }
    }

    private fun goToNextQuestion() {
        if (currentIndex < questions.size - 1) {
            currentIndex++
            showQuestion()
        } else {
            questionText.text = "Quiz Finished!"
            resultText.text = "Your Score: $score / ${questions.size}"
        }
    }
}

