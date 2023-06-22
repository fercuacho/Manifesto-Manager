package com.example.androidejercicio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val name = intent.getStringExtra("EXTRA_NAME")
        val lastName = intent.getStringExtra("EXTRA_LASTNAME")
        val age = intent.getIntExtra("EXTRA_AGE",0)

        val txName = findViewById<TextView>(R.id.txName)
        val txLastName = findViewById<TextView>(R.id.txLastName)
        val txAge = findViewById<TextView>(R.id.txAge)

        txName.text = name
        txLastName.text = lastName
        txAge.text = age.toString()

        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener{
            val returnIntent = Intent().apply{
                putExtra("EXTRA_NAME",name)
                putExtra("EXTRA_LASTNAME",lastName)
                putExtra("EXTRA_AGE",age)

            }
            setResult(RESULT_OK, returnIntent)
            finish()
        }


    }
}