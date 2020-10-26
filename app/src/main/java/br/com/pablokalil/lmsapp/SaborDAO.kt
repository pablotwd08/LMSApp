package br.com.pablokalil.lmsapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SaborDAO {

    @Query("SELECT * FROM sabor where id=:id")
    fun getById(id: Long): Sabor?

    @Query("SELECT * FROM sabor")
    fun findAll(): List<Sabor>

    @Insert
    fun insert(sabor: Sabor)

    @Delete
    fun delete(sabor: Sabor)

    @Query("UPDATE sabor set nome=:nome where marca=:marca")
    fun updateNome(nome: String, marca: String)
}