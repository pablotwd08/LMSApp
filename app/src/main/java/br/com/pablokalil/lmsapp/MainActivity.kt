package br.com.pablokalil.lmsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*


class MainActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        campoImagem.setImageResource(R.drawable.sorvetess)

        botaoLogin.setOnClickListener {
            val valorUsuario = campoUsuario.text.toString()
            val valorSenha = campoSenha.text.toString()
            if (valorUsuario == "aluno") {
                if (valorSenha == "impacta") {
                    var intent = Intent(this, TelaInicialActicity::class.java)
                    var params = Bundle()
                    startActivity(intent)
                } else{
                    Toast.makeText(this, "Senha incorretos", Toast.LENGTH_LONG).show()
                }
            } else{
                Toast.makeText(this, "Usuário incorretos", Toast.LENGTH_LONG).show()
            }
        }
    }
}