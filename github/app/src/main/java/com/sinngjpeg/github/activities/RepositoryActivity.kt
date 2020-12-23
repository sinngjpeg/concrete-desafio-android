package com.sinngjpeg.github.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.sinngjpeg.github.R
import com.sinngjpeg.github.adapter.RepositoryAdapter
import com.sinngjpeg.github.model.Repository

class RepositoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.repository_activity)

        val recyclerView = findViewById<RecyclerView>(R.id.recycle_view_repository_list)
        val item1 = Repository(
            "Repositorio", "descricao", "", 123, "", 323,
            "", "username", "Nome Completo"
        )
        val item2 = Repository(
            "Repositorio2", "descricao2", "", 123, "", 323,
            "", "username2", "Nome Completo2"
        )


        val listRepository = listOf<Repository>(
            item1, item2
        )

        // onde vai receber as informacoes da API
        val adapter = RepositoryAdapter(listRepository)
        recyclerView.adapter = adapter

    }


}