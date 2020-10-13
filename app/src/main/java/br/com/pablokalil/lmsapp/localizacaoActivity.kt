package br.com.pablokalil.lmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_localizacao.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.login.campoImagem
import kotlinx.android.synthetic.main.toolbar.*

class localizacaoActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_localizacao)

        this.generic_layout = layoutMenuLateral

        campoImagem.setImageResource(R.drawable.ic_mapa)

        setSupportActionBar(toolbar_view)

        supportActionBar?.title = "Localização"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        configuraMenuLateral()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item?.itemId
        if (id == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}