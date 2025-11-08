package org.example.cashflow.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface WasteDao {
    @Query("SELECT * FROM  waste")
    suspend fun getAllWaste(): Flow<List<Waste>>
    @Upsert
    suspend fun upsert(waste: Waste)

    @Delete
    suspend fun delete(waste: Waste)
}