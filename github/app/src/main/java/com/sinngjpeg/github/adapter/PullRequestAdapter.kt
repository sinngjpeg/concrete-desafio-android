package com.sinngjpeg.github.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sinngjpeg.github.R
import com.sinngjpeg.github.model.data.PullRequest
import com.sinngjpeg.github.model.data.Repository
import kotlinx.android.synthetic.main.item_pullrequest.view.*

class PullRequestAdapter(
    val pullrequestList: List<PullRequest>,
    val onItemClickListener: ((pullRequests: PullRequest) -> Unit)
) : RecyclerView.Adapter<PullRequestAdapter.PullRequestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_pullrequest, parent, false
        )
        return PullRequestViewHolder(itemView, onItemClickListener)
    }

    override fun getItemCount() = pullrequestList.size

    override fun onBindViewHolder(holder: PullRequestViewHolder, position: Int) {
        holder.bindView(pullrequestList[position])
    }

    class PullRequestViewHolder(
        itemView: View,
        private val onItemClickListener: ((pullRequests: PullRequest) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {
        private val titlePullRequest = itemView.title_pull
        private val descriptionPullRequest = itemView.description_pull
        private val userName = itemView.username_pull
        private lateinit var urlPullrequest: String

        fun bindView(pullrequest: PullRequest) {
            titlePullRequest.text = pullrequest.title
            descriptionPullRequest.text = pullrequest.description
            userName.text = pullrequest.owner.userName
            urlPullrequest = pullrequest.html_url

            Glide.with(itemView.context)
                .load(pullrequest.owner.userPhoto)
                .circleCrop()
                .into(itemView.userPhoto)

            itemView.setOnClickListener {
                onItemClickListener.invoke(pullrequest)
            }
        }
    }
}
