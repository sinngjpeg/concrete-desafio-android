package com.shayanne.desafioshayanne

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MeuAdapter (
        private val minhalista : List<ItensLista>, private val usaOnClickListener: UsaOnClickListener): RecyclerView.Adapter<MeuAdapter.List1ViewHolder>() {

    // cria a view que precisa ser repetida
    // linha 17:cria um objeto do item e nele infla os ids para mostrar na tela,
    // linha 17:o context é onde vamos colocar(main activity)
    // linha 21: retorna a view que devemos criar e repetir
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): List1ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.conteudo_scroll_rep,
        parent, false)

        return List1ViewHolder(itemView)
    }

    //repete a view varias vezes
    // conecta os ids dos itens a posicao que devem ser exibidos
    //por isso passe td na mesma ordem aqui e na classe ItensLista
    override fun onBindViewHolder(holder: List1ViewHolder, position: Int) {
        val posicaoItem = minhalista[position]
        holder.textView1.text = posicaoItem.text1
        holder.textView2.text = posicaoItem.text2
        holder.imageView1.setImageResource(posicaoItem.imageResource1)
        holder.textView3.text = posicaoItem.text3
        holder.textView4.text = posicaoItem.text4
        holder.imageView2.setImageResource(posicaoItem.imageResource2)
        holder.textView5.text = posicaoItem.text5
        holder.imageView3.setImageResource(posicaoItem.imageResource3)
        holder.textView6.text = posicaoItem.text6
    }

    //quantos cards devem ser impressos por pagina?
    override fun getItemCount() = minhalista.size


    //crie a classe para passar todos os ids da view
    //passe tudo na ordem conforme a linha 26 indica
    inner class List1ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView1: TextView = itemView.findViewById(R.id.nome_repositorio)
        val textView2: TextView = itemView.findViewById(R.id.descricao_rep)
        val imageView1: ImageView = itemView.findViewById(R.id.user_rep)
        val textView3: TextView = itemView.findViewById(R.id.username_rep)
        val textView4: TextView = itemView.findViewById(R.id.nome_completo_rep)
        val imageView2: ImageView = itemView.findViewById(R.id.fork)
        val textView5: TextView = itemView.findViewById(R.id.n_conexoes)
        val imageView3: ImageView = itemView.findViewById(R.id.estrela)
        val textView6: TextView = itemView.findViewById(R.id.n_estrelas)

    }


}