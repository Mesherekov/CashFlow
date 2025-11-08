package org.example.cashflow.db.convertDB

import org.example.cashflow.db.WasteCategories
import org.example.cashflow.db.WasteItem
import org.example.cashflow.ui.waste.Currency

class Converter(val wasteItem: WasteItem) {
    val wasteCategories = WasteCategories.entries.toTypedArray().associateBy { it.name}
    val wasteCurrency = Currency.entries.toTypedArray().associateBy { it.name}


    fun getListWaste(): List<WasteCategories?>{
        return wasteItem
            .listWasteCategories
            .split("#")
            .map { wasteCategories[it] }
    }
    fun getListCurrency(): List<Currency?>{
        return wasteItem
            .currency.split("#")
            .map { wasteCurrency[it] }
    }
}