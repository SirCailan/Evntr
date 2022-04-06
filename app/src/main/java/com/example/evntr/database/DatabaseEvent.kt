package com.example.evntr.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat

//We need to convert the event object from the API into this, as the database does not allow
//classes to be stored in a table, as in an image asset.

//The only variable that cannot be null is the unique id.

@Entity(tableName = "events")
data class DatabaseEvent(
    //@ColumnInfo(name = "createdAt") val _createdAt: SimpleDateFormat, //Todo fix
    @PrimaryKey @ColumnInfo(name = "id") val _id: String,
    //@ColumnInfo(name = "revision") val _rev: String,
    @ColumnInfo(name = "type") val _type: String?,
    //@ColumnInfo(name = "updatedAt") val _updatedAt: SimpleDateFormat, //Todo fix
    @ColumnInfo(name = "ageLimit") val age: String?,
    val cover: String?, //URL
    val timeDate: String?,
    val header: String?,
    val image: String?, //URL
    val name: String?,
    val price: String?,
    val text: String?,
    val venue: String?,
    val favorite: Boolean = false,
    val participating: Boolean = false
)