package org.example.cashflow.db

import org.example.cashflow.ui.waste.Currency


data class WasteItemDB(
    val wasteCategory: WasteCategories,
    val cost: Float,
    val currency: Currency
)
