package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val btn=findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
        if(binding.name.text.toString().isEmpty())
        {
            Toast.makeText(this,"Please enter your name",Toast.LENGTH_SHORT).show()
        }
            else
        {
            val intent=Intent(this,QuizQuestionsActivity::class.java).also { it.putExtra("name",binding.name.text.toString())}
            startActivity(intent)
            finish()
        }
        }
    }
}