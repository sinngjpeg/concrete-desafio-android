package com.example.desafiogabriela

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class NotePullrequestAdapter(
    private val lista: List<ItemPullrequest>,
    pullrequestActivity: PullrequestActivity
):
    RecyclerView.Adapter<NotePullrequestAdapter.ViewHolderClass>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_pullrequest, parent, false)

        return ViewHolderClass(itemView)
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
        holder.fullname.text = item.fullname

    }

    class ViewHolderClass (itemView: View) : RecyclerView.ViewHolder(itemView){
        val icon: ImageView = itemView.findViewById(R.id.icone_pullrequest)
        val title: TextView = itemView.findViewById(R.id.titulo_pullrequest)
        val description: TextView = itemView.findViewById(R.id.boby_pullrequest)
        val username: TextView = itemView.findViewById(R.id.username_pullrequest)
        val fullname: TextView = itemView.findViewById(R.id.fullname_pullrequest)
    }

}
