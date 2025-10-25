package org.example.cashflow.db

import org.example.cashflow.ui.waste.WasteCategories

data class WasteItemDB(
    val wasteCategory: WasteCategories,
    val cost: Float
)
