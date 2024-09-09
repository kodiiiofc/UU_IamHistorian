package com.kodiiiofc.example.iamhistorian

import android.net.wifi.aware.Characteristics
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {

    private lateinit var pointsTV: TextView
    private lateinit var characteristicsTV: TextView
    private lateinit var levelTV: TextView
    private lateinit var exitBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        pointsTV = findViewById(R.id.tv_points)
        levelTV = findViewById(R.id.tv_level)
        characteristicsTV = findViewById(R.id.tv_characteristics)
        exitBTN = findViewById(R.id.btn_exit)

        val points = intent.extras!!.getInt("points")
        pointsTV.text = getString(R.string.tv_points) + " " + points + "очков"

        levelTV.text = getLevelAndCharacteristics(points).first
        characteristicsTV.text = getLevelAndCharacteristics(points).second

        exitBTN.setOnClickListener {
            finish()
        }

    }

    private fun getLevelAndCharacteristics(points: Int): Pair<String, String> {
        val result = when (points) {
            in 0..100 -> Pair(getString(R.string.level_1), getString(R.string.characteristics_1))
            in 101..200 -> Pair(getString(R.string.level_2), getString(R.string.characteristics_2))
            in 201..300 -> Pair(getString(R.string.level_3), getString(R.string.characteristics_3))
            in 301..400 -> Pair(getString(R.string.level_4), getString(R.string.characteristics_4))
            else -> Pair(getString(R.string.level_5), getString(R.string.characteristics_5))
        }
        return result
    }

}