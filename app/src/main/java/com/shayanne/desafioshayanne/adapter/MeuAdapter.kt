package com.shayanne.desafioshayanne.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shayanne.desafioshayanne.R
import com.shayanne.desafioshayanne.modelo.DonoRep
import com.shayanne.desafioshayanne.modelo.ItensLista
import com.squareup.picasso.Picasso

class MeuAdapter (
        private val minhalista : List<ItensLista>,
        private val listener: ItemClickListener):
        RecyclerView.Adapter<MeuAdapter.List1ViewHolder>() {

    // cria a view que precisa ser repetida
    // linha 17:cria um objeto do item e nele infla os ids para mostrar na tela,
    // linha 17:o context é onde vamos colocar(main activity)
    // linha 21: retorna a view que devemos criar e repetir
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): List1ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.conteudo_scroll_rep,
                parent, false)

        return List1ViewHolder(itemView)
    }

    //repete a view varias vezes
    // conecta os ids dos itens a posicao que devem ser exibidos
    //por isso passe td na mesma ordem aqui e na classe ItensLista
    override fun onBindViewHolder(holder: List1ViewHolder, position: Int) {
        val posicaoItem = minhalista[position]
        holder.nome_repositorio.text = posicaoItem.nome_repositorio
        holder.descricao_rep.text = posicaoItem.descricao_rep
        //holder.user_rep.setImageResource(posicaoItem.donoRep.user_rep)
        holder.username_rep.text = posicaoItem.donoRep.username_rep
        holder.nome_completo_rep.text = posicaoItem.nome_completo_rep
        //holder.fork.setImageResource(posicaoItem.fork)
        holder.n_conexoes.text = posicaoItem.n_conexoes.toString()
       // holder.estrela.setImageResource(posicaoItem.estrela)
        holder.n_estrelas.text = posicaoItem.n_estrelas.toString()
    }

    //quantos cards devem ser impressos por pagina?
    override fun getItemCount() = minhalista.size


    //crie a classe para passar todos os ids da view
    //passe tudo na ordem conforme a linha 26 indica
    inner class List1ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val nome_repositorio: TextView = itemView.findViewById(R.id.nome_repositorio)
        val descricao_rep: TextView = itemView.findViewById(R.id.descricao_rep)
        val user_rep: ImageView = itemView.findViewById(R.id.user_rep)
        val username_rep: TextView = itemView.findViewById(R.id.username_rep)
        val nome_completo_rep: TextView = itemView.findViewById(R.id.nome_completo_rep)
       // val fork: ImageView = itemView.findViewById(R.id.fork)
        val n_conexoes: TextView = itemView.findViewById(R.id.n_conexoes)
       // val estrela: ImageView = itemView.findViewById(R.id.estrela)
        val n_estrelas: TextView = itemView.findViewById(R.id.n_estrelas)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if( position != RecyclerView.NO_POSITION){
                listener.ItemClick(position)
            }
        }

    }

    interface ItemClickListener{
        fun ItemClick(position: Int)
    }
}

