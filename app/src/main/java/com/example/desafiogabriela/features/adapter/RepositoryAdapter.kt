package com.example.desafiogabriela.features.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiogabriela.features.model.ItemRepository
import com.example.desafiogabriela.R
import com.example.desafiogabriela.features.activity.RepositoryActivity
import com.squareup.picasso.Picasso


class RepositoryAdapter(
    var list: MutableList<ItemRepository>,
    private val listener: RepositoryActivity): RecyclerView.Adapter<RepositoryAdapter.ViewHolderclass>() {

    override fun onBindViewHolder(holder: ViewHolderclass, position: Int) {
        val item = list[position]

        Picasso.get()
            .load(item.owner.image)
            .into(holder.icon)
        holder.nameRepository.text = item.nameRepository
        holder.description.text = item.description
        holder.forks.text = item.forks_count.toString()
        holder.stars.text = item.stars_count.toString()
        holder.username.text = item.owner.username
        holder.fullname.text = item.fullname
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderclass {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)

        return ViewHolderclass(itemView)
    }

    override fun getItemCount() = list.size


    inner class ViewHolderclass(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val icon: ImageView = itemView.findViewById(R.id.icone)
        val nameRepository: TextView = itemView.findViewById(R.id.nome_repositorio)
        val description: TextView = itemView.findViewById(R.id.descricao)
        val forks: TextView = itemView.findViewById(R.id.forks)
        val stars: TextView = itemView.findViewById(R.id.star)
        val username: TextView = itemView.findViewById(R.id.username)
        val fullname: TextView = itemView.findViewById(R.id.fullname)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition

            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}

