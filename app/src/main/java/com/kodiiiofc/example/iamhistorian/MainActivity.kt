package com.kodiiiofc.example.iamhistorian

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var startBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        startBTN = findViewById(R.id.btn_start)

        val questionStorage = QuestionStorage()

        startBTN.setOnClickListener {

            val intent = Intent(this, Questions::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra("counter", 1)
            intent.putExtra("points", 0)
            intent.putExtra("questionStorage",questionStorage)

            startActivity(intent)

        }

    }
}