package com.example.readingwarehouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class CalculatorActivity : AppCompatActivity() {
    private lateinit var editTextPrice: EditText
    private lateinit var editTextDiscount: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)

        editTextPrice = findViewById(R.id.editTextPrice)
        editTextDiscount = findViewById(R.id.editTextDiscount)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)

        calculateButton.setOnClickListener {
            Calculator.calculateDiscount(editTextPrice, editTextDiscount, resultTextView)
        }

        val home_nav = findViewById<ImageButton>(R.id.home_nav)
        val tobuy_nav = findViewById<ImageButton>(R.id.tobuy_nav)
        val scan_nav = findViewById<ImageButton>(R.id.scan_nav)
        val myshelf_nav = findViewById<ImageButton>(R.id.myshelf_nav)

        home_nav.setOnClickListener {
            // Create an Intent to start the ToBuyActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        tobuy_nav.setOnClickListener {
            // Create an Intent to start the ToBuyActivity
            val intent = Intent(this, ToBuyActivity::class.java)
            startActivity(intent)
        }

        scan_nav.setOnClickListener {
            val intent = Intent(this, ScanBarActivity::class.java)
            startActivity(intent)
        }

        myshelf_nav.setOnClickListener {
            // Create an Intent to start the ToBuyActivity
            val intent = Intent(this, MyShelfActivity::class.java)
            startActivity(intent)
        }
    }

}