package com.example.readingwarehouse

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
// for home page
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;


//class MainActivity : AppCompatActivity() {
//    private lateinit var editTextPrice: EditText
//    private lateinit var editTextDiscount: EditText
//    private lateinit var calculateButton: Button
//    private lateinit var resultTextView: TextView
//
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        setContentView(R.layout.calculator)
////
////        editTextPrice = findViewById(R.id.editTextPrice)
////        editTextDiscount = findViewById(R.id.editTextDiscount)
////        calculateButton = findViewById(R.id.calculateButton)
////        resultTextView = findViewById(R.id.resultTextView)
////
////        calculateButton.setOnClickListener {
////            Calculator.calculateDiscount(editTextPrice, editTextDiscount, resultTextView)
////        }
////    }
//
//}

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = BookAdapter(bookList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val tobuy_nav = findViewById<ImageButton>(R.id.tobuy_nav)
        val scan_nav = findViewById<ImageButton>(R.id.scan_nav)
        val myshelf_nav = findViewById<ImageButton>(R.id.myshelf_nav)
        val cal_nav = findViewById<ImageButton>(R.id.cal_nav)

        tobuy_nav.setOnClickListener {
            // Create an Intent to start the ToBuyActivity
            val intent = Intent(this, ToBuyActivity::class.java)
            startActivity(intent)
        }

        scan_nav.setOnClickListener {
            val intent = Intent(this, ScanBarActivity::class.java)
            startActivity(intent)
        }

        cal_nav.setOnClickListener {
            // Create an Intent to start the ToBuyActivity
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        myshelf_nav.setOnClickListener {
            // Create an Intent to start the ToBuyActivity
            val intent = Intent(this, MyShelfActivity::class.java)
            startActivity(intent)
        }


    }
}