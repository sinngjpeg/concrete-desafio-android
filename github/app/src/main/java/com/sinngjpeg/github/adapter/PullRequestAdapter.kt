package com.sinngjpeg.github.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sinngjpeg.github.R
import com.sinngjpeg.github.model.PullRequest
import kotlinx.android.synthetic.main.item_pullrequest.view.*

class PullRequestAdapter(
     val pullrequestList: List<PullRequest>
     ) : RecyclerView.Adapter<PullRequestAdapter.PullRequestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.item_pullrequest, parent, false
        )
        return PullRequestViewHolder(itemView)

    }

    override fun getItemCount() = pullrequestList.size

    override fun onBindViewHolder(holder: PullRequestViewHolder, position: Int) {
        holder.bindView(pullrequestList[position])
    }

    class PullRequestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tituloPullRequest = itemView.txt__titulo_pull
        private val descricaoPullRequest = itemView.txt_descricao_pull
        private val userName = itemView.txt_username_pull
//        private val data = itemView???


        fun bindView(pullrequest: PullRequest) {

            tituloPullRequest.text = pullrequest.title
            descricaoPullRequest.text = pullrequest.descricaoRepository
            userName.text = pullrequest.proprietario.userName


            Glide.with(itemView.context)
                .load(pullrequest.proprietario.urlFoto)
                .circleCrop()
                .into(itemView.img_profile_pull)
        }
    }
}