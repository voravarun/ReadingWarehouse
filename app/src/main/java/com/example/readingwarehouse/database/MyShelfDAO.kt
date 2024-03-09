package com.example.readingwarehouse.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.readingwarehouse.Entites.MyShelf

@Dao
interface MyShelfDAO {

    @Query("SELECT * FROM MyShelf_table")
    fun allMyShelf(): List<MyShelf>

    @Query("SELECT * FROM MyShelf_table WHERE barcode = :barcode LIMIT 1")
    fun findByBarcode(barcode: Int): MyShelf?

    @Insert
    fun insert(myShelf: MyShelf)

    @Query("DELETE FROM MyShelf_table")
    fun deleteAll()
}
