package com.shayanne.desafioshayanne

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity() : AppCompatActivity(), MeuAdapter.ItemClickListener{

    private val  pegaLista = geraLista(500)
    private val adapter = MeuAdapter(pegaLista, this)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //  pega o id do recycleview que esta no activity_main e coloca numa variavel para poder usar
        val idDoMeuRecycleView = findViewById<RecyclerView>(R.id.recyclerview_id)

        // a linha 31 cria uma lista linear para scrolar
        idDoMeuRecycleView.adapter = adapter
        idDoMeuRecycleView.layoutManager = LinearLayoutManager(this)
        idDoMeuRecycleView.setHasFixedSize(true)

        // intent usado para testar o return da segunda tela, pra retornar até a primeira pagina, vide manifest tb
        // se colocado aqui a primeira tela que vai aparecer é a Detalherepositorio, se tirar, é a MainActivity
        //passei pra fun  ItemClick
        //val intencao = Intent(this, DetalheRepositorio::class.java)
       // startActivity(intencao)


    }

    override fun ItemClick(position: Int) {
        //passa o Intent pra chamar o DetalheRepositorio, e o startActivity pra mostra-la na tela
        val intencao = Intent(this, DetalheRepositorio::class.java)
        startActivity(intencao)

    }

    private fun geraLista(size:Int): List<ItensLista>{
        val lista = ArrayList<ItensLista>()

        for(i in 0 until size) {
            val drawable1 = when(i % 3){
                0 -> R.drawable.ic_user
                else -> R.drawable.ic_user
            }
            val drawable2 = when(i % 3){
                0 -> R.drawable.ic_fork
                else -> R.drawable.ic_fork
            }
            val drawable3 = when(i % 3){
                0 -> R.drawable.ic_estrela
                else -> R.drawable.ic_estrela
            }

            // passar na ordem correta vide a classe MeuAdapter
            val item = ItensLista(
                    "Nome Repositorio",
                    "Descrever o conteúdo do repositorio aqui, este .. ",
                    drawable1,
                    "username",
                    "Nome Sobrenome",
                    drawable2,
                    "640",
                    drawable3,
                    "98" )
            lista += item
        }
        return lista
    }

}