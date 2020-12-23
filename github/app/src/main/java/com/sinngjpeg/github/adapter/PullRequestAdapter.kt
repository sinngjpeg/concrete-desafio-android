package com.sinngjpeg.github.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sinngjpeg.github.R
import com.sinngjpeg.github.model.PullRequest

class PullRequestAdapter(private val pullrequestList: List<PullRequest>) :
    RecyclerView.Adapter<PullRequestAdapter.PullRequestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_pullrequest, parent, false
        )
        return PullRequestViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: PullRequestViewHolder, position: Int) {
        val currentItem = pullrequestList[position]
        holder.nomeRepository.text = currentItem.nomeRepository
        holder.descricaoRepository.text = currentItem.descricaoRepository
        holder.userName.text = currentItem.userName
        holder.fullName.text = currentItem.fullName

    }

    override fun getItemCount() = pullrequestList.size

    class PullRequestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeRepository: TextView = itemView.findViewById(R.id.txt__titulo_pull)
        val descricaoRepository: TextView = itemView.findViewById(R.id.txt_descricao_pull)
        val userName: TextView = itemView.findViewById(R.id.txt_username_pull)
        val fullName: TextView = itemView.findViewById(R.id.txt_nome_sobrenome_pull)
    }
}
