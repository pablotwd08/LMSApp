package br.com.pablokalil.lmsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial_acticity.*
import kotlinx.android.synthetic.main.navigation_menu.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActicity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial_acticity)


        this.generic_layout = layoutMenuLateral

        val args = intent.extras
        val nome = args?.getString("nome_usuario")
        val numero = args?.getInt("numero")
        Toast.makeText(this, "Bem Vindo", Toast.LENGTH_LONG).show()

        setSupportActionBar(toolbar_view)

        supportActionBar?.title = "Sabores"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        configuraMenuLateral()


        recyclerSabores?.layoutManager = LinearLayoutManager(this)
        recyclerSabores?.itemAnimator = DefaultItemAnimator()
        recyclerSabores?.setHasFixedSize(true)
        val professor = Prefs.getString("professor")
        Toast.makeText(this, professor, Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        taksSabores()
    }

    var sabores = listOf<Sabor>()

    fun taksSabores() {
        Thread {
            this.sabores = SaboresService.getSabores()
            runOnUiThread {
                recyclerSabores?.adapter =
                    SaboresAdapter(sabores) {
                        onClickSabor(it)
                    }
                enviaNotificacao(this.sabores[0])
            }
        }.start()
    }

    fun enviaNotificacao(sabor: Sabor) {
        val intent = Intent(this, SaborActivity::class.java)
        intent.putExtra("sabor", sabor)

        NotficationUtil.create(1, intent, "LMSApp", "Ops Esse sorvete acabou ${sabor.nome}")
    }

    fun onClickSabor(sabor: Sabor) {
        val it = Intent(this, SaborActivity::class.java)
        it.putExtra("sabor", sabor)
        startActivity(it)
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
        }  else if (id == R.id.action_config) {
            var intent = Intent(this, ConfiguracaoActivity::class.java)
            var params = Bundle()
                startActivity(intent)
        } else if (id == R.id.action_sair) {
            finish()
        } else if (id == R.id.action_nova) {
            var intent = Intent(this, NovoSaborActivity::class.java)
            var params = Bundle()
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

}

