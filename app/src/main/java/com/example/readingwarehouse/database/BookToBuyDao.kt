package com.example.readingwarehouse.database

import androidx.room.*
import com.example.readingwarehouse.Entites.BookToBuy


@Dao
interface BookToBuyDao {

    @Query("SELECT * FROM book_tobuy")
    fun getAllBToBuy(): List<BookToBuy>

    @Insert
    fun insertBToBuy(entity: BookToBuy)

    @Delete
    fun deleteBToBuy(entity: BookToBuy)

}