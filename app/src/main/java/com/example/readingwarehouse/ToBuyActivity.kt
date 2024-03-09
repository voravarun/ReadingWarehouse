package com.example.readingwarehouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.readingwarehouse.databinding.ToBuyBinding
import com.example.readingwarehouse.Entites.BookToBuy
import com.example.readingwarehouse.database.AppDatabase
import com.example.readingwarehouse.databinding.TobuybitemBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ToBuyActivity : AppCompatActivity() {

    private lateinit var binding: ToBuyBinding
    private lateinit var adapter: TobuyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ToBuyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = findViewById<RecyclerView>(R.id.tobuy_item)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = TobuyAdapter(emptyList())
        recyclerView.adapter = adapter

        getBToBuy()

        binding.addBuyB.setOnClickListener{
            val intent = Intent(this, ToBuyFormActivity::class.java)
            startActivity(intent)
        }

        val home_nav = findViewById<ImageButton>(R.id.home_nav)
        val scan_nav = findViewById<ImageButton>(R.id.scan_nav)
        val myshelf_nav = findViewById<ImageButton>(R.id.myshelf_nav)
        val cal_nav = findViewById<ImageButton>(R.id.cal_nav)

        home_nav.setOnClickListener {
            // Create an Intent to start the ToBuyActivity
            val intent = Intent(this, MainActivity::class.java)
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

    private fun getBToBuy() {
        val database = AppDatabase.getDatabase(applicationContext)
        CoroutineScope(Dispatchers.IO).launch {
            val data = database.BookToBuyDao().getAllBToBuy()
            withContext(Dispatchers.Main) {
                adapter.setData(data)
            }
        }
    }
//
//    private fun deleteBToBuy(){
//        val bname = Bbinding.bookName.text.toString().trim()
//        val bauthor = Bbinding.bookAuthor.text.toString().trim()
//        val bvol = Bbinding.bookVol.text.toString().trim().toIntOrNull()
//        val bprice = Bbinding.bookPrice.text.toString().trim().toIntOrNull()
//        val book = BookToBuy(bname, bauthor, bvol, bprice)
//        showDeleteConfirmationDialog(book)
//    }

    private fun showDeleteConfirmationDialog(book: BookToBuy) {
        // Implement a dialog to confirm the deletion
        AlertDialog.Builder(this)
            .setTitle("Delete Item")
            .setMessage("Are you sure you want to delete this item?")
            .setPositiveButton("Delete") { _, _ ->
                val database = AppDatabase.getDatabase(applicationContext)
                CoroutineScope(Dispatchers.IO).launch {
                    database.BookToBuyDao().deleteBToBuy(book)
                    getBToBuy()
                }
                finish()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

}