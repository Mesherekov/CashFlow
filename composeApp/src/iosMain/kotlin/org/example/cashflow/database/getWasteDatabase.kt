package org.example.cashflow.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import org.example.cashflow.db.WasteDatabase
import platform.Foundation.NSHomeDirectory

fun getWasteDatabase(): WasteDatabase {
    val dbFile = NSHomeDirectory() + "/waste.db"
    return Room.databaseBuilder<WasteDatabase>(
        name = dbFile,
        factory = { WasteDatabase::class.instantiateImpl()}
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}