// MainActivity.kt
package com.example.readingwarehouse


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.readingwarehouse.databinding.ActivityMainBinding
import com.example.readingwarehouse.database.MyShelfDatabase
import com.example.readingwarehouse.databinding.NavMenuBinding
import com.example.readingwarehouse.databinding.ToBuyBinding
import com.example.readingwarehouse.databinding.TobuybitemBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyShelfActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MyShelfAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize RecyclerView and set its layout manager
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewBooksMyshelf)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize the adapter with an empty list
        adapter = MyShelfAdapter(emptyList())
        recyclerView.adapter = adapter

        // Fetch data from the database and update the adapter
        fetchDataFromDatabase()

        // Set click listener for the "Add Book" button
        binding.addBookButton.setOnClickListener {
            // Create an Intent to start the MyShelfFormActivity
            val intent = Intent(this, MyShelfFormActivity::class.java)
            startActivityForResult(intent, MY_SHELF_FORM_REQUEST_CODE)
        }

        // Set click listener for the "To Buy" button

        val home_nav = findViewById<ImageButton>(R.id.home_nav)
        val tobuy_nav = findViewById<ImageButton>(R.id.tobuy_nav)
        val scan_nav = findViewById<ImageButton>(R.id.scan_nav)
        val cal_nav = findViewById<ImageButton>(R.id.cal_nav)

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

        cal_nav.setOnClickListener {
            // Create an Intent to start the ToBuyActivity
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        binding.refreshButton.setOnClickListener {
            fetchDataFromDatabase()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == MY_SHELF_FORM_REQUEST_CODE && resultCode == RESULT_OK) {
            // Refresh data in the adapter after adding a new item
            fetchDataFromDatabase()
        }
    }

    private fun fetchDataFromDatabase() {
        val database = MyShelfDatabase.getDatabase(applicationContext)
        CoroutineScope(Dispatchers.IO).launch {
            val data = database.myShelfDao().allMyShelf()
            withContext(Dispatchers.Main) {
                adapter.setData(data)
            }
        }
    }

    companion object {
        private const val MY_SHELF_FORM_REQUEST_CODE = 100
    }
}
