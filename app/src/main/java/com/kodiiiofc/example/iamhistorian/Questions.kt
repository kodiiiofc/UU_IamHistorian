package com.kodiiiofc.example.iamhistorian

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.core.view.forEach

class Questions : AppCompatActivity() {

    private lateinit var submitBTN: Button
    private lateinit var questionTV: TextView
    private lateinit var questionHeaderTV: TextView
    private lateinit var answersRG: RadioGroup

    private lateinit var firstAnswerRB: RadioButton
    private lateinit var secondAnswerRB: RadioButton
    private lateinit var thirdAnswerRB: RadioButton
    private lateinit var fourthAnswerRB: RadioButton

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)

        submitBTN = findViewById(R.id.btn_submit)
        questionHeaderTV = findViewById(R.id.tv_question_header)
        questionTV = findViewById(R.id.tv_question)
        answersRG = findViewById(R.id.rg_answers)

        firstAnswerRB = findViewById(R.id.rb_first_answer)
        secondAnswerRB = findViewById(R.id.rb_second_answer)
        thirdAnswerRB = findViewById(R.id.rb_third_answer)
        fourthAnswerRB = findViewById(R.id.rb_fourth_answer)

        val questionStorage = intent.extras!!.getParcelable<QuestionStorage>("questionStorage")
        var currentCounter = intent.extras!!.getInt("counter")
        var points = intent.extras!!.getInt("points")

        questionHeaderTV.text =
            resources.getString(R.string.tv_question_header) + " " + "$currentCounter"

        val currentQuestion = questionStorage!!.getQuestion()

        questionTV.text = currentQuestion.question

        for (radioButton in answersRG.children) {
            if (radioButton is RadioButton) {
                radioButton.text = currentQuestion.answers[radioButton.id % 10 - 1]
            }
        }

        submitBTN.setOnClickListener {

            val id = answersRG.checkedRadioButtonId
            if (id != -1) {
                val answer: RadioButton = findViewById(id)
                if (answer.id % 10 - 1 == currentQuestion.correctAnswer) {
                    points += 100
                }

                if (currentCounter < 5) {
                    intent.putExtra("counter", currentCounter + 1)
                    intent.putExtra("points", points)
                    intent.putExtra("questionStorage", questionStorage)
                    startActivity(intent)
                    finish()
                }

                else {
                    val resultIntent = Intent(this, ResultActivity::class.java)
                    resultIntent.putExtra("points", points)
                    startActivity(resultIntent)
                    finish()
                }

            }

        }
    }

    override fun onBackPressed() {
        // super.onBackPressed()
        Log.d("TAG", "onBackPressed: Back is forbidden here")
    }
}