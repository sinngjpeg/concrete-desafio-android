package com.shayanne.desafioshayanne.repository

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shayanne.desafioshayanne.R
import com.shayanne.desafioshayanne.model.RepositoryRequests
import com.squareup.picasso.Picasso

class RepositoryAdapter(
    val minhalista: MutableList<RepositoryRequests>,
    private val listener: RepositoryActivity
) :
    RecyclerView.Adapter<RepositoryAdapter.List1ViewHolder>() {

    // cria a view que precisa ser repetida
    // cria um objeto do item e nele infla os ids para mostrar na tela,
    // o context é onde vamos colocar(main activity)
    //  retorna a view que devemos criar e repetir
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): List1ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.scroll_rep,
            parent, false
        )

        return List1ViewHolder(itemView)
    }

    //repete a view varias vezes
    // conecta os ids dos itens a posicao que devem ser exibidos
    //por isso passe td na mesma ordem aqui
    override fun onBindViewHolder(holder: List1ViewHolder, position: Int) {
        val posicaoItem = minhalista[position]
        holder.nome_repositorio.text = posicaoItem.name
        holder.descricao_rep.text = posicaoItem.description
        Picasso.get()
            .load(posicaoItem.owner.avatarUrl)
            .into(holder.user_rep)
        holder.username_rep.text = posicaoItem.owner.login
        holder.nome_completo_rep.text = posicaoItem.fullName
        holder.n_conexoes.text = posicaoItem.forksCount.toString()
        holder.n_estrelas.text = posicaoItem.stargazersCount.toString()
    }


    override fun getItemCount() = minhalista.size

    fun addRepositories(items: List<RepositoryRequests>) {
        val previousCount = itemCount
        minhalista.addAll(items)
        notifyItemRangeInserted(previousCount, items.size)
    }


    inner class List1ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val nome_repositorio: TextView = itemView.findViewById(R.id.nome_repositorio)
        val descricao_rep: TextView = itemView.findViewById(R.id.descricao_rep)
        val user_rep: ImageView = itemView.findViewById(R.id.user_rep)
        val username_rep: TextView = itemView.findViewById(R.id.username_rep)
        val nome_completo_rep: TextView = itemView.findViewById(R.id.nome_completo_rep)
        val n_conexoes: TextView = itemView.findViewById(R.id.n_conexoes)
        val n_estrelas: TextView = itemView.findViewById(R.id.n_estrelas)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.CreateIntentClick(position)
            }
        }
    }

    interface ItemClickListener {
        fun CreateIntentClick(position: Int)
    }


}

