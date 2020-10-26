package br.com.pablokalil.lmsapp

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class SaboresAdapter(
    val sabores: List<Sabor>,
    val onClick: (Sabor) -> Unit
): RecyclerView.Adapter<SaboresAdapter.SaboresViewHolder>() {

    class SaboresViewHolder(view: View): RecyclerView.ViewHolder(view){
        val cardNome: TextView
        val cardImg: ImageView
        val cardProgress: ProgressBar

        init {
            cardNome = view.findViewById(R.id.cardNome)
            cardImg = view.findViewById(R.id.cardImg)
            cardProgress = view.findViewById(R.id.cardProgress)
        }

    }

    override fun getItemCount() = this.sabores.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaboresViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_sabor, parent, false)

        val holder = SaboresViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: SaboresViewHolder, posicao: Int) {
        val sabor = this.sabores[posicao]

        holder.cardNome.text = sabor.nome
        holder.cardProgress.visibility = View.VISIBLE

        val context = holder.itemView.context
        val resources: Resources = context.resources
        val resourceId: Int = resources.getIdentifier(
                "sorvetess",
                "drawable",
                context.packageName)
        //holder.cardImg.setImageResource(resourceId)

        //download da img
        Picasso.with(holder.itemView.context).load(sabor.foto).fit().into(holder.cardImg, object: com.squareup.picasso.Callback {
            override fun onSuccess() {
                holder.cardProgress.visibility = View.GONE
            }
            override fun onError() {
                holder.cardProgress.visibility = View.GONE
            }
        })

        holder.itemView.setOnClickListener {onClick(sabor)}
    }

}