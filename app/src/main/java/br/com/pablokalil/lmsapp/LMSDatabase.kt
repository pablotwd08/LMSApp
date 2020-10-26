package br.com.pablokalil.lmsapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities= arrayOf(Sabor::class), version = 1)
abstract class LMSDatabase :RoomDatabase() {
    abstract fun saborDAO(): SaborDAO
}