package br.com.pablokalil.lmsapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SaboresAdapter(
    val sabores: List<Sabor>,
    val onClick: (Sabor) -> Unit
) {


    class SaboresViewHolder(view: View): RecyclerView.ViewHolder(view){
    }

}