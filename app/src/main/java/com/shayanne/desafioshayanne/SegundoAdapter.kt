package com.shayanne.desafioshayanne

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SegundoAdapter (private val minhalista2: List<ItensLista2>): RecyclerView.Adapter <SegundoAdapter.List2ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): List2ViewHolder {
        val itemView2 = LayoutInflater.from(parent.context).inflate(R.layout.conteudo_scroll_pull,
                parent, false)

        return List2ViewHolder(itemView2)

    }


    //repete a view varias vezes
    // conecta os ids dos itens a posicao que devem ser exibidos
    //por isso passe td na mesma ordem aqui e na classe ItensLista
    override fun onBindViewHolder(holder: List2ViewHolder, position: Int) {
        val posicaoItem = minhalista2[position]
        holder.textView7.text = posicaoItem.text7
        holder.textView8.text = posicaoItem.text8
        holder.imageView4.setImageResource(posicaoItem.imageResource4)
        holder.textView9.text = posicaoItem.text9
        holder.textView10.text = posicaoItem.text10
    }

    //quantos cards devem ser impressos por pagina?
    override fun getItemCount() = minhalista2.size




    class List2ViewHolder(itemView2: View) : RecyclerView.ViewHolder(itemView2){
        val textView7 : TextView = itemView2.findViewById(R.id.titulo_pull)
        val textView8 : TextView = itemView2.findViewById(R.id.descricao_pull)
        val imageView4: ImageView = itemView2.findViewById(R.id.user_pull)
        val textView9 : TextView = itemView2.findViewById(R.id.username_pull)
        val textView10 : TextView = itemView2.findViewById(R.id.nome_completo_pull)
    }


}