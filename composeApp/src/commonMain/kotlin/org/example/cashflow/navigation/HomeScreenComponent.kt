package org.example.cashflow.navigation

import androidx.compose.runtime.LaunchedEffect
import co.touchlab.kermit.Logger
import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import org.example.cashflow.db.Waste
import org.example.cashflow.db.WasteDatabase
import org.example.cashflow.navigation.interfaces.HomeComponent

class HomeScreenComponent(
    componentContext: ComponentContext,
   val wasteDatabase: WasteDatabase
): ComponentContext by componentContext, HomeComponent {
    private val listWaste = wasteDatabase.wasteDao().getAllWaste()
    override fun getWastes(): Flow<List<Waste>> {
       return listWaste
    }


    override fun updateWaste(waste: Waste) {
        CoroutineScope(Dispatchers.IO).launch{
            wasteDatabase.wasteDao().upsert(waste)
        }

    }

    override fun deleteWaste(waste: Waste) {
        CoroutineScope(Dispatchers.IO).launch {
            wasteDatabase.wasteDao().delete(waste)
        }
    }

    override fun convertData(listWaste: List<Waste>) {
        TODO("Not yet implemented")
    }

}