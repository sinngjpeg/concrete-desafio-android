package com.shayanne.desafioshayanne

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetalheRepositorio: AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.toolbar_det_repositorio)

        val  pegaLista2 = geraLista2(500)

        //  pega o id do recycleview que esta no activity_main e coloca numa variavel para poder usar
        val idDoSegundoRecycleView = findViewById<RecyclerView>(R.id.recyclerview_id2)

        // a linha 30 cria uma lista linear para scrolar
        idDoSegundoRecycleView.adapter = SegundoAdapter(pegaLista2)
        idDoSegundoRecycleView.layoutManager = LinearLayoutManager(this)
        idDoSegundoRecycleView.setHasFixedSize(true)

        //BOTAO DE RETORNAR, VIDE LINHA 19 DO MANIFEST TB
        setSupportActionBar(findViewById(R.id.toolbar2))
        supportActionBar!!.title = "Go Back"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }
    private fun geraLista2(size:Int): List<ItensLista2>{
        val lista2 = ArrayList<ItensLista2>()

        for(i in 0 until size) {
            val drawable4 = when(i % 3){
                0 -> R.drawable.ic_user
                else -> R.drawable.ic_user
            }


            // passar na ordem correta vide a classe MeuAdapter
            val item = ItensLista2(
                    "Titulo do pull request",
                    "Body do pull request, aqui colocamos a descricao ",
                    drawable4,
                    "username",
                    "Nome Sobrenome"
                    )
            lista2 += item
        }
        return lista2
    }
}