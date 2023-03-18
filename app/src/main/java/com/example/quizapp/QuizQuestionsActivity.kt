package com.example.quizapp

import android.content.Intent
import android.graphics.Color.parseColor
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizQuestionsBinding
    private var MQuestionsList: ArrayList<Question>? = null
    var selected:Int=0
    var change=0;
    var correct=0;

    private var pos: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        MQuestionsList = Constants.getQuestions()
        setQues()


    }

    private fun setQues() {

        pos++

        binding.optionThree.setBackgroundResource(R.drawable.border_bg)
        binding.optionThree.setTypeface(Typeface.DEFAULT)
        binding.optionTwo.setBackgroundResource(R.drawable.border_bg)
        binding.optionTwo.setTypeface(Typeface.DEFAULT)
        binding.optionOne.setBackgroundResource(R.drawable.border_bg)
        binding.optionOne.setTypeface(Typeface.DEFAULT)
        binding.optionFour.setBackgroundResource(R.drawable.border_bg)
        binding.optionFour.setTypeface(Typeface.DEFAULT)



        var ques = MQuestionsList!!.get(pos - 1)

        binding.progressBar.progress = pos
        binding.tvProg.text = "$pos" + "/" + "${binding.progressBar.max}"

        binding.tvQues.text = ques.question
        binding.imageID.setImageResource(ques.image)
        binding.optionOne.text = ques.optionOne
        binding.optionTwo.text = ques.optionTwo
        binding.optionThree.text = ques.optionThree
        binding.optionFour.text = ques.optionFour

    }

    fun onPress(v: View){
        if (change==0) {
            if (v.id == 2131231043) {
                Log.i("Button 1", "clicked")
                binding.optionOne.setBackgroundResource(R.drawable.selected_border)
                binding.optionOne.setTypeface(Typeface.DEFAULT_BOLD)
                binding.optionTwo.setBackgroundResource(R.drawable.border_bg)
                binding.optionTwo.setTypeface(Typeface.DEFAULT)
                binding.optionThree.setBackgroundResource(R.drawable.border_bg)
                binding.optionThree.setTypeface(Typeface.DEFAULT)
                binding.optionFour.setBackgroundResource(R.drawable.border_bg)
                binding.optionFour.setTypeface(Typeface.DEFAULT)
                selected = 1

            } else if (v.id == 2131231045) {
                Log.i("btn 2", "clicked")
                binding.optionTwo.setBackgroundResource(R.drawable.selected_border)
                binding.optionTwo.setTypeface(Typeface.DEFAULT_BOLD)
                binding.optionOne.setBackgroundResource(R.drawable.border_bg)
                binding.optionOne.setTypeface(Typeface.DEFAULT)
                binding.optionThree.setBackgroundResource(R.drawable.border_bg)
                binding.optionThree.setTypeface(Typeface.DEFAULT)
                binding.optionFour.setBackgroundResource(R.drawable.border_bg)
                binding.optionFour.setTypeface(Typeface.DEFAULT)
                selected = 2
            } else if (v.id == 2131231044) {
                Log.i("btn 3", "clicked")
                binding.optionThree.setBackgroundResource(R.drawable.selected_border)
                binding.optionThree.setTypeface(Typeface.DEFAULT_BOLD)
                binding.optionTwo.setBackgroundResource(R.drawable.border_bg)
                binding.optionTwo.setTypeface(Typeface.DEFAULT)
                binding.optionOne.setBackgroundResource(R.drawable.border_bg)
                binding.optionOne.setTypeface(Typeface.DEFAULT)
                binding.optionFour.setBackgroundResource(R.drawable.border_bg)
                binding.optionFour.setTypeface(Typeface.DEFAULT)
                selected = 3
            } else if (v.id == 2131231042) {
                Log.i("btn 4", "clicked")

                binding.optionFour.setBackgroundResource(R.drawable.selected_border)
                binding.optionFour.setTypeface(Typeface.DEFAULT_BOLD)
                binding.optionTwo.setBackgroundResource(R.drawable.border_bg)
                binding.optionTwo.setTypeface(Typeface.DEFAULT)
                binding.optionThree.setBackgroundResource(R.drawable.border_bg)
                binding.optionThree.setTypeface(Typeface.DEFAULT)
                binding.optionOne.setBackgroundResource(R.drawable.border_bg)
                binding.optionOne.setTypeface(Typeface.DEFAULT)
                selected = 4

            }
        }

    }
    fun sub(v:View)
    {
        val a=binding.button.text.toString()
        if (a=="Submit")
        {
            var ques = MQuestionsList!!.get(pos - 1)

            if(selected==ques.correctAnswer)
            {
                Log.i("result","correct")
                if (selected==4)
                {
                    binding.optionFour.setBackgroundResource(R.drawable.correct)
                    correct++;
                }
                else if (selected==1)
                {
                    binding.optionOne.setBackgroundResource(R.drawable.correct)
                    correct++;
                }
                else if (selected==2)
                {
                    binding.optionTwo.setBackgroundResource(R.drawable.correct)
                    correct++;
                }
                else if (selected==3)
                {
                    binding.optionThree.setBackgroundResource(R.drawable.correct)
                    correct++;
                }

            }
            else
            {
                Log.i("result","Incorrect")
                if (selected==4)
                {
                    binding.optionFour.setBackgroundResource(R.drawable.incorrect)
                }
                else if (selected==1)
                {
                    binding.optionOne.setBackgroundResource(R.drawable.incorrect)
                }
                else if (selected==2)
                {
                    binding.optionTwo.setBackgroundResource(R.drawable.incorrect)
                }
                else if (selected==3)
                {
                    binding.optionThree.setBackgroundResource(R.drawable.incorrect)
                }
                if (ques.correctAnswer==1)
                {
                    binding.optionOne.setBackgroundResource(R.drawable.correct)
                }
                else if (ques.correctAnswer==2)
                {
                    binding.optionTwo.setBackgroundResource(R.drawable.correct)
                }
                else if (ques.correctAnswer==3)
                {
                    binding.optionThree.setBackgroundResource(R.drawable.correct)
                }
                else if (ques.correctAnswer==4)
                {
                    binding.optionFour.setBackgroundResource(R.drawable.correct)
                }

            }
            binding.button.text="NEXT"
            change=1
        }
        else{
            change=0
            if (pos==9)
            {
                Log.i("status","Time to end ${pos}");
                result();
            }
            else {
                setQues()
                binding.button.text = "Submit"
            }

        }

    }

    fun result()
    {
        val intent= Intent(this,ResultActivity::class.java)
        intent.putExtra("score",correct)
        intent.putExtra("correct",pos)
        startActivity(intent)
        finish()

    }



}