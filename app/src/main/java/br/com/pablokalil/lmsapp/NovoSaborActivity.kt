package br.com.pablokalil.lmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_novo_sabor.*

class NovoSaborActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_sabor)

        botaoSalvar.setOnClickListener {
            val d = Sabor()
            d.nome = nomeSabor.text.toString()
            d.marca = marca.text.toString()
            d.foto = foto.text.toString()
            d.zero = zero.text.toString()
            if (d.nome.equals("")) {

            }
            Thread {
                SaboresService.saveSabor(d)
                runOnUiThread {
                    finish()
                }
            }.start()
        }
    }
}