package com.sinngjpeg.github.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sinngjpeg.github.R
import com.sinngjpeg.github.model.data.Repository
import kotlinx.android.synthetic.main.item_repository.view.*


class RepositoryAdapter(
    val repository: List<Repository>,
    val onItemClickListener: ((repository: Repository) -> Unit)
) : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_repository, parent, false
        )
        return RepositoryViewHolder(itemView, onItemClickListener)
    }

    override fun getItemCount() = repository.count()

    override fun onBindViewHolder(viewholder: RepositoryViewHolder, position: Int) {
        viewholder.bindView(repository[position])
    }

    class RepositoryViewHolder(
        itemView: View,
        private val onItemClickListener: ((repository: Repository) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {

        private val nameRepository = itemView.title_repository
        private val descriptionRepository = itemView.description_repository
        private val qntForks = itemView.qnt_forks_repository
        private val qntStars = itemView.qnt_stars_repository
        private val userName = itemView.username_repository

        fun bindView(repository: Repository) {
            nameRepository.text = repository.title
            descriptionRepository.text = repository.description
            qntForks.text = repository.qntStars.toString()
            qntStars.text = repository.qntForks.toString()
            userName.text = repository.owner.userName

            Glide.with(itemView.context)
                .load(repository.owner.userPhoto)
                .circleCrop()
                .into(itemView.user_photo)

            itemView.setOnClickListener {
                onItemClickListener.invoke(repository)
            }
        }
    }
}