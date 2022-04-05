package com.example.evntr.database

import androidx.room.*

@Dao
interface EventsDao {
    @Query("SELECT * FROM events WHERE id =:eventId")
    fun getEvent(eventId: String): Event

    @Query("SELECT * FROM events")
    fun getAllEvents(): List<Event>

    @Query("SELECT * FROM events WHERE favorite = 1")
    fun getFavoriteEvents() : List<Event>

    @Query("SELECT * FROM events WHERE participating = 1")
    fun getParticipatingEvents() : List<Event>

    @Insert
    fun addEvent(event: Event)

    @Update
    fun updateEvent(event: Event)

    @Query("DELETE FROM events")
    fun deleteAllEvents()

    @Delete
    fun deleteEvent(event: Event)
}