package com.sinngjpeg.github.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.sinngjpeg.github.R
import com.sinngjpeg.github.model.Repository


class RepositoryAdapter(private val repositoryList: List<Repository>) :
    Adapter<RepositoryAdapter.RepositoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_repository, parent, false
        )
        return RepositoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val currentItem = repositoryList[position]
        holder.nomeRepository.text = currentItem.nomeRepository
        holder.descricaoRepository.text = currentItem.descricaoRepository
    }

    override fun getItemCount() = repositoryList.size


    class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeRepository: TextView = itemView.findViewById(R.id.txt_nome_repository)
        val descricaoRepository: TextView = itemView.findViewById(R.id.txt_descricao_repository)
    }
}