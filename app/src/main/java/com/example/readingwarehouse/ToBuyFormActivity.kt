package com.example.readingwarehouse

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageButton
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.example.readingwarehouse.databinding.ToBuyFormBinding
import com.example.readingwarehouse.Entites.BookToBuy
import com.example.readingwarehouse.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToBuyFormActivity : AppCompatActivity() {

    private lateinit var binding: ToBuyFormBinding
    private lateinit var select_Img: AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ToBuyFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        select_Img = findViewById(R.id.select_img)

        binding.addImg.setOnClickListener{
            val img = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            changeImage.launch(img)
        }

        binding.addItem.setOnClickListener {
            addBToBuy()
        }

        val home_nav = findViewById<ImageButton>(R.id.home_nav)
        val tobuy_nav = findViewById<ImageButton>(R.id.tobuy_nav)
        val scan_nav = findViewById<ImageButton>(R.id.scan_nav)
        val myshelf_nav = findViewById<ImageButton>(R.id.myshelf_nav)
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

        myshelf_nav.setOnClickListener {
            // Create an Intent to start the ToBuyActivity
            val intent = Intent(this, MyShelfActivity::class.java)
            startActivity(intent)
        }

    }

    private val changeImage =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                val data = it.data
                val imgUri = data?.data
                binding.selectImg.setImageURI(imgUri)
              }
        }

    private fun addBToBuy() {
        val bname = binding.bookName.text.toString().trim()
        val bauthor = binding.bookAuthor.text.toString().trim()
        val bvol = binding.bookVol.text.toString().trim().toIntOrNull()
        val bprice = binding.bookPrice.text.toString().trim().toIntOrNull()

        if (bname.isNotEmpty() && bauthor.isNotEmpty() && bvol != null && bprice != null) {
            val bToBuy = BookToBuy(bname, bauthor, bvol, bprice)
            print("pass")
            insertBToBuy(bToBuy)

        } else {
            // Handle invalid input
        }
    }

    private fun insertBToBuy(book: BookToBuy) {
        val database = AppDatabase.getDatabase(applicationContext)
        CoroutineScope(Dispatchers.IO).launch {
            database.BookToBuyDao().insertBToBuy(book)
        }
        finish()
    }
}


