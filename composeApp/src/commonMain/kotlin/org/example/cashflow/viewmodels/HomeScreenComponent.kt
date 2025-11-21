package org.example.cashflow.viewmodels

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.example.cashflow.db.Waste
import org.example.cashflow.db.WasteCard
import org.example.cashflow.db.WasteDatabase
import org.example.cashflow.db.convertDB.Converter
import org.example.cashflow.viewmodels.interfaces.HomeComponent
import org.jetbrains.compose.resources.StringResource

class HomeScreenComponent(
    componentContext: ComponentContext,
    val wasteDatabase: WasteDatabase
): ComponentContext by componentContext, HomeComponent {
    private val _stateFlowWaste = MutableStateFlow<List<Waste>>(emptyList())
    val itemsState: StateFlow<List<Waste>> = _stateFlowWaste.asStateFlow()

    override fun createWaste(wasteCard: WasteCard) {
        CoroutineScope(Dispatchers.IO).launch {
            wasteDatabase.wasteDao().upsert(
                Converter.convertWasteCard(wasteCard)
            )
        }
    }

    override fun getWastes(): Flow<List<Waste>> {
       return wasteDatabase.wasteDao().getAllWaste()
    }


    override fun updateWaste(waste: Waste) {
        CoroutineScope(Dispatchers.IO).launch {
            wasteDatabase.wasteDao().upsert(waste)
        }

    }

    override fun deleteWaste(waste: Waste) {
        CoroutineScope(Dispatchers.IO).launch {
            wasteDatabase.wasteDao().delete(waste)
        }
    }

    override fun convertData(listWaste: List<Waste>) {

    }

    override fun statisticsWaste(listWasteCard: List<WasteCard>): List<Pair<StringResource, Float>> {
        val statistics = mutableListOf<Pair<StringResource, Float>>()
        val sumWastes = mutableListOf<Float>()
        listWasteCard.forEach {
            sumWastes.add(
                it.listWaste.sumOf {
                    item -> item.cost.toDouble()
                }.toFloat()
            )
        }
        return emptyList()
    }


}