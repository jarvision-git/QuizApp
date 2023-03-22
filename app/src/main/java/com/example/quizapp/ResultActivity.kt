package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.databinding.ActivityQuizQuestionsBinding
import com.example.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val score =intent.getIntExtra("score",0)
        Log.i("score","${score}")
        binding.score.text="You scored $score out of 9"

    }
}