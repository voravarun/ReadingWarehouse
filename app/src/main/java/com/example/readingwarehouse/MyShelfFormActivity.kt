package com.example.readingwarehouse

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageButton
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.readingwarehouse.databinding.ActivityMyShelfFormBinding
import com.example.readingwarehouse.database.MyShelfDatabase
import com.example.readingwarehouse.Entites.MyShelf
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyShelfFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyShelfFormBinding
    private lateinit var imageUri: Uri



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyShelfFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.pickImage.setOnClickListener {
//            openGalleryForImage()
//        }

        binding.addButton.setOnClickListener {
            saveBookToShelf()
        }

        binding.backButton.setOnClickListener {
            onBackPressed() // Navigate back to the previous activity (MainActivity)
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

//    private fun openGalleryForImage() {
//        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
//        pickImage.launch(intent)
//    }

//    private val pickImage = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//        if (result.resultCode == RESULT_OK) {
//            val data: Intent? = result.data
//            imageUri = data?.data ?: Uri.EMPTY
//            binding.selectedImage.setImageURI(imageUri)
//        }
//    }

    private fun saveBookToShelf() {
        val title = binding.titleEditText.text.toString().trim()
        val barcode = binding.barcodeEditText.text.toString().trim().toIntOrNull()
        val volumeNo = binding.volumeEditText.text.toString().trim().toIntOrNull()
        val author = binding.authorEditText.text.toString().trim()

        if (barcode != null && volumeNo != null && title.isNotEmpty() && author.isNotEmpty()) {
            val myShelf = MyShelf(barcode, title, author, volumeNo)
            insertIntoDatabase(myShelf)
        } else {
            // Handle invalid input
        }
    }

    private fun insertIntoDatabase(myShelf: MyShelf) {
        val database = MyShelfDatabase.getDatabase(applicationContext)
        CoroutineScope(Dispatchers.IO).launch {
            database.myShelfDao().insert(myShelf)
        }
        finish()
    }
}
