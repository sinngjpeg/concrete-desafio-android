package com.sinngjpeg.github.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.sinngjpeg.github.R
import com.sinngjpeg.github.activities.PullRequestActivity
import com.sinngjpeg.github.model.PullRequest
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
        holder.numeroDeForks.text = currentItem.numeroDeForks.toString()
        holder.numeroDeStars.text = currentItem.numeroDeStars.toString()
        holder.userName.text = currentItem.userName
        holder.fullName.text = currentItem.fullName

    }

    override fun getItemCount() = repositoryList.size


    class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeRepository: TextView = itemView.findViewById(R.id.txt_nome_repository)
        val descricaoRepository: TextView = itemView.findViewById(R.id.txt_descricao_repository)
        val numeroDeForks: TextView = itemView.findViewById(R.id.txt_numero_forks)
        val numeroDeStars: TextView = itemView.findViewById(R.id.txt_numero_stars)
        val userName: TextView = itemView.findViewById(R.id.txt_username)
        val fullName: TextView = itemView.findViewById(R.id.txt_nome_completo)
    }
}