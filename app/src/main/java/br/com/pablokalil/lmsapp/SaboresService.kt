package br.com.pablokalil.lmsapp

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.net.URL

object SaboresService {

    val host = "https://fesousa.pythonanywhere.com"
    val TAG = "WS_LMSApp"

    fun getSabores (): List<Sabor> {

     //   val url = "$host/disciplinas"
    //    val json = HttpHelper.get(url)
     //   Log.d(TAG, json)
//
      //  return parserJson<List<Sabor>>(json)
        return DatabaseManager.getSaborDAO().findAll()
    }

    fun saveSabor(sabor: Sabor) {
 //       val json = GsonBuilder().create().toJson(sabor)
 //       HttpHelper.post("$host/disciplinas", json)
        DatabaseManager.getSaborDAO().insert(sabor)
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object: TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}