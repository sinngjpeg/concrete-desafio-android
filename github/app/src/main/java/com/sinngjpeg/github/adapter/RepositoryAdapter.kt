package com.sinngjpeg.github.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.sinngjpeg.github.R
import com.sinngjpeg.github.model.Repository
import com.sinngjpeg.github.model.RepositoryModel


class RepositoryAdapter(private val repositoryList: List<RepositoryModel>) :
        Adapter<RepositoryAdapter.RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.item_repository, parent, false)
        return RepositoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {

        holder.bindView(repositoryList[position])
    }

    override fun getItemCount() = repositoryList.size


    class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nomeRepository: TextView = itemView.findViewById(R.id.txt_nome_repository)
        private val descricaoRepository: TextView = itemView.findViewById(R.id.txt_descricao_repository)
        private val numeroDeForks: TextView = itemView.findViewById(R.id.txt_numero_forks)
        private val numeroDeStars: TextView = itemView.findViewById(R.id.txt_numero_stars)
        private val userName: TextView = itemView.findViewById(R.id.txt_username)
        private val fullName: TextView = itemView.findViewById(R.id.txt_nome_completo)
        // passar o val da photo configurada com o picasso

        fun bindView(repository: Repository) {
            nomeRepository.text = repository.nomeRepository
            descricaoRepository.text = repository.descricaoRepository
            numeroDeForks.text = repository.numeroDeForks.toString()
            numeroDeStars.text = repository.numeroDeStars.toString()
            userName.text = repository.userName
            fullName.text = repository.fullName
        }
    }
}