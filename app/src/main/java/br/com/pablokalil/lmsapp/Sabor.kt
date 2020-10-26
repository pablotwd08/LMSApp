package br.com.pablokalil.lmsapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName="sabor")
class Sabor: Serializable {

    @PrimaryKey
    var id: Long = 0
    var nome = ""
    var zero= ""
    var marca = ""
    var foto = ""

    override fun toString(): String {
        return "Sabor(nome=$nome)"
    }
}
