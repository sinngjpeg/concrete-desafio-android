package com.example.desafiogabriela.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiogabriela.model.ItemPullrequest
import com.example.desafiogabriela.R
import com.example.desafiogabriela.activity.PullrequestActivity
import com.squareup.picasso.Picasso


class PullrequestAdapter(
    var lista: List<ItemPullrequest>,
    pullrequestActivity: PullrequestActivity ) :
    RecyclerView.Adapter<PullrequestAdapter.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView =
            ViewHolderClass(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_pullrequest, parent, false)
            )
        return itemView

    }

    override fun getItemCount() = lista.size


    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

        val item = lista[position]

        Picasso.get()
            .load(item.owner.avatar_url)
            .into(holder.icon)
        holder.title.text = item.name
        holder.description.text = item.description
        holder.username.text = item.owner.login
       // holder.fullname.text = item.fullname

    }


    inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val icon: ImageView = itemView.findViewById(R.id.icone_pullrequest)
        val title: TextView = itemView.findViewById(R.id.titulo_pullrequest)
        val description: TextView = itemView.findViewById(R.id.boby_pullrequest)
        val username: TextView = itemView.findViewById(R.id.username_pullrequest)
        val fullname: TextView = itemView.findViewById(R.id.fullname_pullrequest)

    }

}
