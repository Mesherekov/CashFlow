package org.example.cashflow.db


import kotlinx.serialization.Serializable
import org.example.cashflow.ui.waste.Currency

@Serializable
data class WasteCard(
    val cost: List<Float>,
    val listWasteCategories: List<WasteCategories>,
    val currency: List<Currency>,
    val date: String
)
