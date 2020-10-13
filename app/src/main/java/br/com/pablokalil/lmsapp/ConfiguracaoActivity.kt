package br.com.pablokalil.lmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_configuracao.*
import kotlinx.android.synthetic.main.toolbar.*

class ConfiguracaoActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracao)

        this.generic_layout = layoutMenuLateral

        setSupportActionBar(toolbar_view)

        supportActionBar?.title = "Configuração"
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