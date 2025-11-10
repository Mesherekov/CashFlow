package org.example.cashflow.db.convertDB

import androidx.room.TypeConverter
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
    fun getListCost(): List<Float>{
        return waste
            .cost.split("#")
            .map { it.toFloat() }
    }
    companion object{
        @TypeConverter
        fun convertWaste(listWaste: List<WasteCategories>): String{
            var convertedList = listWaste.first().name
            listWaste.forEach {
                convertedList += "#" + it.name
            }
            return convertedList
        }
        @TypeConverter
        fun convertCurrency(listCurrency: List<Currency>): String{
            var convertedList = listCurrency.first().name
            listCurrency.forEach {
                convertedList += "#" + it.name
            }
            return convertedList
        }
        @TypeConverter
        fun convertCost(listCost: List<Float>): String{
            var convertedList = listCost.first().toString()
            listCost.forEach {
                convertedList += "#$it"
            }
            return convertedList
        }
    }

}