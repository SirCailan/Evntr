package com.example.evntr.database

import androidx.room.*

@Dao
interface EventsDao {
    @Query("SELECT * FROM events WHERE id =:eventId")
    fun getEvent(eventId: String): DatabaseEvent

    @Query("SELECT * FROM events")
    fun getAllEvents(): List<DatabaseEvent>

    @Query("SELECT * FROM events WHERE favorite = 1")
    fun getFavoriteEvents() : List<DatabaseEvent>

    @Query("SELECT * FROM events WHERE participating = 1")
    fun getParticipatingEvents() : List<DatabaseEvent>

    @Insert
    fun addEvent(databaseEvent: DatabaseEvent)

    @Update
    fun updateEvent(databaseEvent: DatabaseEvent)

    @Query("DELETE FROM events")
    fun deleteAllEvents()

    @Delete
    fun deleteEvent(databaseEvent: DatabaseEvent)
}