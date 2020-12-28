package com.example.desafiogabriela

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PullrequestActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pullrequest)

        setSupportActionBar(findViewById(R.id.pull_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val exemplo  = generateDummyList(500)


        var pullrequest = findViewById<RecyclerView>(R.id.pullrequest)


        pullrequest.adapter = NotePullrequestAdapter(exemplo)
        pullrequest.layoutManager = LinearLayoutManager(this)
        pullrequest.setHasFixedSize(true)

    }

    private fun generateDummyList(size: Int): List<ItemPullrequest> {
        val list = ArrayList<ItemPullrequest>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_pessoa
                1 -> R.drawable.ic_pessoa
                else -> R.drawable.ic_pessoa
            }
            val item = ItemPullrequest (drawable, "Título do Pullrequest","descriptionkjsfnvfvvyujyyvytvfvjuikhghdxfghvbjhjfctghvjkghvjknlytfevjugnlmfomlioerfnanvlifjvrjvdfivndflijvleriovodfnvdifovrt", "username","Nome Sobrenome")
            list += item
        }
        return list
    }
}