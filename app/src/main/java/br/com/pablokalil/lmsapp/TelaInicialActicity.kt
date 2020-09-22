package br.com.pablokalil.lmsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial_acticity.*

class TelaInicialActicity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial_acticity)

        val args = intent.extras
        val nome = args?.getString("nome_usuario")
        val numero = args?.getInt("numero")
        Toast.makeText(this, "Bem Vindo", Toast.LENGTH_LONG).show()

        supportActionBar?.title = "Sabores"

        buttonChocolate.setOnClickListener {
            var intent = Intent(this, ChocolateActivity::class.java)
            var params = Bundle()
            startActivity(intent)
        }
        buttonMorango.setOnClickListener {
            var intent = Intent(this, MorangoActivity::class.java)
            var params = Bundle()
            startActivity(intent)
        }
        buttonCreme.setOnClickListener {
            var intent = Intent(this, CremeActivity::class.java)
            var params = Bundle()
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item?.itemId
        if (id == R.id.action_buscar) {
            Toast.makeText(this, "Botão de pesquisa", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_atualizar) {
            Toast.makeText(this, "Botão de atualizar", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_adicionar) {
            var intent = Intent(this, CadastroActivity::class.java)
            var params = Bundle()
                startActivity(intent)
        } else if (id == R.id.action_config) {
            var intent = Intent(this, ConfiguracaoActivity::class.java)
            var params = Bundle()
                startActivity(intent)
        } else if (id == R.id.action_sair) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}

