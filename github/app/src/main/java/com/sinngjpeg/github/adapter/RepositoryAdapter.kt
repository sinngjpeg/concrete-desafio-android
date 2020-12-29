package com.sinngjpeg.github.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sinngjpeg.github.R
import com.sinngjpeg.github.model.Repository
import kotlinx.android.synthetic.main.item_repository.view.*


class RepositoryAdapter(
    val repository: List<Repository>
) : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {

    //item de layout - infla o layout do item_repository
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_repository, parent, false
        )
        return RepositoryViewHolder(itemView)
    }

    //quantidade de item que tem na lista
    override fun getItemCount() = repository.count()

    //ligacao dos itens da lista com o recycle view
    override fun onBindViewHolder(viewholder: RepositoryViewHolder, position: Int) {
        viewholder.bindView(repository[position])
    }

    class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //vincula com o layout
        private val nomeRepository = itemView.txt_nome_repository
        private val descricaoRepository = itemView.txt_descricao_repository
        private val numeroDeForks = itemView.txt_numero_forks
        private val numeroDeStars = itemView.txt_numero_stars
        private val userName = itemView.txt_username


        //vincula com o repositorymodel
        fun bindView(repository: Repository) {
            nomeRepository.text = repository.nomeRepository
            descricaoRepository.text = repository.descricaoRepository
            numeroDeForks.text = repository.numeroDeForks.toString()
            numeroDeStars.text = repository.numeroDeStars.toString()
            userName.text = repository.proprietario.userName

            Glide.with(itemView.context)
                .load(repository.proprietario.urlFoto)
                .circleCrop()
                .into(itemView.img_profile_request)

        }
    }

}