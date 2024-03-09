package com.example.readingwarehouse
import androidx.room.Entity
import androidx.room.PrimaryKey
//@Entity(tableName = "books")
//data class Book(
//    @PrimaryKey(autoGenerate = true)
//    val id: Int = 0,
//    val name: String,
//    val author: String,
//    val volume: Int,
//    val price: Int,
//    // Add any other properties you need
//)
data class Book(
    val id: Int = 0,
    val name: String,
    val author: String,
    val volume: Int,
    val price: Int,
    // Add any other properties you need
)


val bookList = listOf(
    Book(123,"Book 1", "A",1, 100),
    Book(456,"Book 2", "B", 2, 200),
    Book(789,"Book 1", "A",2, 120),
)