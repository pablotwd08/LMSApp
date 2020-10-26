package br.com.pablokalil.lmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SaborActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sabor)
        val sabor = intent.getSerializableExtra("sabor")
        Toast.makeText(this, "$sabor", Toast.LENGTH_LONG).show()
    }
}