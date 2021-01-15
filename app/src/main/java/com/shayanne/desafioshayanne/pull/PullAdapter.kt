package com.shayanne.desafioshayanne.pull

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shayanne.desafioshayanne.R
import com.shayanne.desafioshayanne.model.PullRequests
import com.squareup.picasso.Picasso

class PullAdapter(


    private val minhalistapull: List<PullRequests>,

    private val callUrl: ItemClickListener
) :
    RecyclerView.Adapter<PullAdapter.List2ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): List2ViewHolder {
        val itemView2 = LayoutInflater.from(parent.context).inflate(
            R.layout.scroll_pull,
            parent, false
        )

        return List2ViewHolder(itemView2)

    }


    override fun onBindViewHolder(holder: List2ViewHolder, position: Int) {
        val posicaoItem = minhalistapull[position]
        holder.titulo_pull.text = posicaoItem.title
        holder.descricao_pull.text = posicaoItem.body
        Picasso.get()
            .load(posicaoItem.user.avatarUrl)
            .into(holder.user_pull)
        holder.username_pull.text = posicaoItem.user.login
        holder.nome_completo_pull.text = posicaoItem.fullName
        holder.itemView.setOnClickListener { callUrl.CreateIntentClickPullUrl(posicaoItem/*position*/) }


    }

    override fun getItemCount() = minhalistapull.size


    inner class List2ViewHolder(itemView2: View) : RecyclerView.ViewHolder(itemView2) {
        val titulo_pull: TextView = itemView2.findViewById(R.id.titulo_pull)
        val descricao_pull: TextView = itemView2.findViewById(R.id.descricao_pull)
        val user_pull: ImageView = itemView2.findViewById(R.id.user_pull)
        val username_pull: TextView = itemView2.findViewById(R.id.username_pull)
        val nome_completo_pull: TextView = itemView2.findViewById(R.id.nome_completo_pull)

    }

    interface ItemClickListener {
        fun CreateIntentClickPullUrl(item: PullRequests/*position: Int*/)
    }


}