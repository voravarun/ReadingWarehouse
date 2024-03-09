package com.example.readingwarehouse.Entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "MyShelf_table")
data class MyShelf(
    @PrimaryKey val barcode: Int?,
    @ColumnInfo(name = "Title") val Title: String?,
    @ColumnInfo(name = "Author") val Author: String?,
    @ColumnInfo(name = "volume_no") val VolumeNo : Int?
)
