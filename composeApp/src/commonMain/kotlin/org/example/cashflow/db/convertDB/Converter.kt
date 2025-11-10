package org.example.cashflow.db.convertDB

import org.example.cashflow.db.WasteCategories
import org.example.cashflow.db.Waste
import org.example.cashflow.ui.waste.Currency

class Converter(val waste: Waste) {
    val wasteCategories = WasteCategories.entries.toTypedArray().associateBy { it.name}
    val wasteCurrency = Currency.entries.toTypedArray().associateBy { it.name}


    fun getListWaste(): List<WasteCategories?>{
        return waste
            .listWasteCategories
            .split("#")
            .map { wasteCategories[it] }
    }
    fun getListCurrency(): List<Currency?>{
        return waste
            .currency.split("#")
            .map { wasteCurrency[it] }
    }
    companion object{
        fun convertToString(listWaste: List<WasteCategories>): String{
            var convertedList = listWaste.first().name
            listWaste.forEach {
                convertedList += "#" + it.name
            }
            return convertedList
        }
        fun convertToString(listCurrency: List<Currency>): String{
            var convertedList = listCurrency.first().name
            listCurrency.forEach {
                convertedList += "#" + it.name
            }
            return convertedList
        }
    }

}