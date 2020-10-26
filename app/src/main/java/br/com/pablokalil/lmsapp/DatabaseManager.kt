package br.com.pablokalil.lmsapp

import androidx.room.Room

object DatabaseManager {

    private var dbInstance: LMSDatabase

    init {
        val contexto = LMSApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            contexto,
            LMSDatabase::class.java,
            "lms.sqllite"
        ).build()
    }

    fun getSaborDAO(): SaborDAO {
        return dbInstance.saborDAO()
    }
}