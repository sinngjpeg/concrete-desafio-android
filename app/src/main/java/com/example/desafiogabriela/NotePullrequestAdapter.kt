package com.example.desafiogabriela

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotePullrequestAdapter(private val lista: List<ItemPullrequest>):
    RecyclerView.Adapter<NotePullrequestAdapter.ViewHolderClass>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_pullrequest, parent, false)

        return ViewHolderClass(itemView)
    }

    override fun getItemCount() = lista.size


    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

        val item = lista[position]

        holder.imagem.setImageResource(item.imagem)

        holder.texto1.text = item.texto1
        holder.texto2.text = item.texto2
        holder.texto3.text = item.texto3
        holder.texto4.text = item.texto4

    }

    class ViewHolderClass (itemView: View) : RecyclerView.ViewHolder(itemView){
        val imagem: ImageView = itemView.findViewById(R.id.icone_pullrequest)
        val texto1: TextView = itemView.findViewById(R.id.titulo_pullrequest)
        val texto2: TextView = itemView.findViewById(R.id.boby_pullrequest)
        val texto3: TextView = itemView.findViewById(R.id.username_pullrequest)
        val texto4: TextView = itemView.findViewById(R.id.fullname_pullrequest)
    }

}