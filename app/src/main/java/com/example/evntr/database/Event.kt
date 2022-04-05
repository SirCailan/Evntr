package com.example.evntr.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat

@Entity(tableName = "events")
data class Event(
    @ColumnInfo(name = "createdAt") val _createdAt: SimpleDateFormat, //Todo fix
    @PrimaryKey @ColumnInfo(name = "id") val _id: String,
    @ColumnInfo(name = "revision") val _rev: String,
    @ColumnInfo(name = "type") val _type: String,
    @ColumnInfo(name = "updatedAt") val _updatedAt: SimpleDateFormat, //Todo fix
    @ColumnInfo(name = "ageLimit") val age: String,
    val cover: Asset,
    val date: String,
    val header: String,
    val image: Asset,
    val name: String,
    val price: String,
    val text: String,
    val venue: String,
    val favorite: Boolean = false,
    val participating: Boolean = false
)