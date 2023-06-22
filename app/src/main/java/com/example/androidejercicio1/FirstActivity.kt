package com.example.androidejercicio1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult

class FirstActivity : AppCompatActivity() {

    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->
        if (result.resultCode == RESULT_OK)    {
            Toast.makeText(this, "EXTRA_NAME = ${result.data?.getStringExtra("EXTRA_NAME")} LAST_NAME= ${result.data?.getStringExtra("EXTRA_LASTNAME")} EXTRA_AGE = ${result.data?.getStringExtra("EXTRA_AGE")}", Toast.LENGTH_LONG).show()
        } else{
            Toast.makeText(this, "CANCELLED", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val btnCall = findViewById<Button>(R.id.btnCall)

        btnCall.setOnClickListener{
            val secondIntent = Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA_NAME","Fernando")
                putExtra("EXTRA_LASTNAME", "Cristobal Huerta")
                putExtra("EXTRA_AGE", 25)
            }
            //startActivity(secondIntent)
            register.launch(secondIntent)
        }
    }
}