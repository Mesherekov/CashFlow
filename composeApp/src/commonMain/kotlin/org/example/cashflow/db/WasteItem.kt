package org.example.cashflow.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WasteItem(
    val cost: String,
    val listWasteCategories: String,
    @PrimaryKey val id: Int = 0,
    val currency: String,
    val date: String
    )
