package org.example.cashflow.navigation.interfaces

import kotlinx.coroutines.flow.Flow
import org.example.cashflow.db.Waste

interface HomeComponent {
    fun getWastes(): Flow<List<Waste>>
    fun updateWaste(waste: Waste)
    fun deleteWaste(waste: Waste)
    fun convertData(listWaste: List<Waste>)

}