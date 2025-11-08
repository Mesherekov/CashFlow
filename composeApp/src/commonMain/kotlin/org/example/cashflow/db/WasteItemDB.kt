package org.example.cashflow.db

import org.example.cashflow.db.WasteCategories


data class WasteItemDB(
    val wasteCategory: WasteCategories,
    val cost: Float
)
