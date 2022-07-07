package com.andry.marvelapplication.data.room.daos

import androidx.room.*
import com.andry.marvelapplication.data.models.Comic

@Dao
interface ComicDao {
    @Query("SELECT * FROM comic")
    suspend fun getAll(): List<Comic>

    @Query("SELECT * FROM comic WHERE id IN (:comicIds) LIMIT 1")
    suspend fun loadById(comicIds: Int): Comic

    @Insert
    suspend fun insertAll(comics: List<Comic>)

    @Delete
    suspend fun delete(comic: Comic)

    @Query("DELETE FROM comic")
    suspend fun deleteAllComics()
}