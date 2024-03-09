package com.example.readingwarehouse.Entites

import androidx.appcompat.widget.AppCompatImageView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "book_tobuy")
data class BookToBuy(
//    @PrimaryKey val barcode: Int?,
    @PrimaryKey val bName: String,
//    @ColumnInfo(name = "book_image") var bImage: AppCompatImageView,
    @ColumnInfo(name = "book_author") var bAuthor: String?,
    @ColumnInfo(name = "book_volume") var bVol: Int?,
    @ColumnInfo(name = "book_price") var bPrice: Int?
)
