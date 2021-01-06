package com.shayanne.desafioshayanne.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shayanne.desafioshayanne.R
import com.shayanne.desafioshayanne.activity.PullActivity
import com.shayanne.desafioshayanne.modelo.PullRequests
import com.squareup.picasso.Picasso

class PullAdapter(

    //  private val listener: RecyclerView.OnScrollListener
    val minhalistapull: List<PullRequests>,
    //private val listener :PullActivity,
    private val callUrl: ItemClickListener
):
    RecyclerView.Adapter <PullAdapter.List2ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): List2ViewHolder {
        val itemView2 = LayoutInflater.from(parent.context).inflate(R.layout.conteudo_scroll_pull,
                parent, false)

        return List2ViewHolder(itemView2)

    }


    //repete a view varias vezes
    // conecta os ids dos itens a posicao que devem ser exibidos
    //por isso passe td na mesma ordem aqui e na classe ItensLista
    override fun onBindViewHolder(holder: List2ViewHolder, position: Int) {
        val posicaoItem = minhalistapull[position]
        holder.titulo_pull.text = posicaoItem.titulo_pull
        holder.descricao_pull.text = posicaoItem.descricao_pull
        //holder.user_pull.setImageResource(posicaoItem.user_pull)

        Picasso.get()
            .load(posicaoItem.donoRep.user_rep)
            .into(holder.user_pull)

        holder.username_pull.text = posicaoItem.donoRep.username_rep
        holder.nome_completo_pull.text = posicaoItem.nome_completo_pull

        holder.itemView.setOnClickListener{callUrl.CreateIntentClickPullUrl(position)}

       
    }

    //quantos cards devem ser impressos por pagina?
    override fun getItemCount() = minhalistapull.size




   inner class List2ViewHolder(itemView2: View) : RecyclerView.ViewHolder(itemView2) {
        val titulo_pull : TextView = itemView2.findViewById(R.id.titulo_pull)
        val descricao_pull : TextView = itemView2.findViewById(R.id.descricao_pull)
        val user_pull: ImageView = itemView2.findViewById(R.id.user_pull)
        val username_pull : TextView = itemView2.findViewById(R.id.username_pull)
        val nome_completo_pull : TextView = itemView2.findViewById(R.id.nome_completo_pull)

    }

    interface ItemClickListener{
        fun CreateIntentClickPullUrl(position: Int)
    }




}