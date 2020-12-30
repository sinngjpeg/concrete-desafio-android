package com.shayanne.desafioshayanne.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shayanne.desafioshayanne.R
import com.shayanne.desafioshayanne.adapter.PullAdapter
import com.shayanne.desafioshayanne.databinding.ToolbarDetRepositorioBinding
import com.shayanne.desafioshayanne.modelo.PullRequests
import com.shayanne.desafioshayanne.webservices.InicializadorRepositories
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
//import com.shayanne.desafioshayanne.databinding.ActivityPullBinding

class PullActivity : AppCompatActivity(),PullAdapter.ItemClickListener {

    var repositorio =""
    var owner = ""
    var nome =""
    var picture = ""
    private val callGit by lazy { InicializadorRepositories.initRep() }
    private lateinit var bindingpull: ToolbarDetRepositorioBinding
    private lateinit var idDoRecycleViewPull: RecyclerView
    //private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingpull = ToolbarDetRepositorioBinding.inflate(layoutInflater)
        setContentView(bindingpull.root)

        viewManager = LinearLayoutManager(this)
        //  viewAdapter = MeuAdapter(pegaLista2)

        idDoRecycleViewPull = findViewById<RecyclerView>(R.id.recyclerview_id_pull).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            //  adapter = viewAdapter

        }

        repositorio = intent.getStringExtra(PullActivity.repositorio).toString()
        owner = intent.getStringExtra(PullActivity.owner).toString()
        nome = intent.getStringExtra(PullActivity.nome).toString()
        picture = intent.getStringExtra(PullActivity.picture).toString()

        //BOTAO DE RETORNAR, VIDE LINHA 24  DO MANIFEST TB
        setSupportActionBar(findViewById(R.id.toolbar2))
        supportActionBar!!.title =repositorio
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        callGit.getPullRequests(owner,repositorio).enqueue(object : Callback<List<PullRequests>> {

            override fun onFailure(call: Call<List<PullRequests>>, t: Throwable) {
                Log.d("Erro", t.message.toString())
                Toast.makeText(this@PullActivity, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<PullRequests>>, response: Response<List<PullRequests>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        bindingpull.recyclerviewIdPull.adapter =
                                PullAdapter(it as MutableList<PullRequests>, this@PullActivity)
                    }
                }
            }
        })
    }

    companion object {
        const val repositorio = "repositorio"
        const val owner = "owner"
        const val nome = "nome"
        const val picture = "picture"

   }


    override fun CreateIntentClickPull(position: Int) {
        //passa o Intent pra chamar o DetalheRepositorio, e o startActivity pra mostra-la na tela
        //val intent = Intent(this, PullActivity::class.java)
        // intent.putExtra(PullActivity.owner, repositoryAdapter.minhalista[position].donoRep.username_rep)
        // intent.putExtra(PullActivity.picture, repositoryAdapter.minhalista[position].donoRep.user_rep)
        //intent.putExtra(PullActivity.repositorio, repositoryAdapter.minhalista[position].nome_repositorio)
        //intent.putExtra(PullActivity.nome,pullAdapter.minhalistapull[position].nome_completo_pull )
        startActivity(intent)//passar o nome do reposito e do usuario
    }

}

