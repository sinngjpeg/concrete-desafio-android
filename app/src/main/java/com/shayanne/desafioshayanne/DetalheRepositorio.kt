package com.shayanne.desafioshayanne

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

class DetalheRepositorio: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.toolbar_det_repositorio)

        //BOTAO DE RETORNAR, VIDE LINHA 19 DO MANIFEST TB
        setSupportActionBar(findViewById(R.id.toolbar2))
        supportActionBar!!.title = "Go Back"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }
}