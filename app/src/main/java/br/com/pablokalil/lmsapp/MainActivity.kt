package br.com.pablokalil.lmsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*


class MainActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        campoUsuario.setText(Prefs.getString("lembrarNome"))
        campoSenha.setText(Prefs.getString("lembrarSenha"))
        checkLembrar.isChecked = Prefs.getBoolean("lembrar")


        campoImagem.setImageResource(R.drawable.sorvetess)

        botaoLogin.setOnClickListener {
            val valorUsuario = campoUsuario.text.toString()
            val valorSenha = campoSenha.text.toString()

            Prefs.setBoolean("lembrar", checkLembrar.isChecked)
            if (checkLembrar.isChecked) {
                Prefs.setString("lembrarNome", valorUsuario)
                Prefs.setString("lembrarSenha", valorSenha)
            } else {
                Prefs.setString("lembrarNome", "")
                Prefs.setString("lembrarSenha", "")
            }

            if (valorUsuario == "aluno") {
                if (valorSenha == "impacta") {
                    var intent = Intent(this, TelaInicialActicity::class.java)
                    var params = Bundle()
                    startActivity(intent)
                } else{
                    Toast.makeText(this, "Senha incorreta", Toast.LENGTH_LONG).show()
                }
            } else{
                Toast.makeText(this, "Usuário incorreto", Toast.LENGTH_LONG).show()
            }
        }
    }
}