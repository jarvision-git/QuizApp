package com.example.quizapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityResultBinding
import java.sql.Types.NULL

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val bundle = intent.extras
        val fname= bundle?.getString("name")
        val fscore= bundle?.getInt("score")
        Log.i("score","${fscore}")
        Log.i("name","${fname}")
        binding.score.text="You scored $fscore out of 9"
        if (fscore != null) {
            if (fscore>5) {
                binding.msg.text="Congratulations ${fname}!"
            }
            else
            {
                binding.msg.text="${fname} better luck next time"
            }
        }


    }
}