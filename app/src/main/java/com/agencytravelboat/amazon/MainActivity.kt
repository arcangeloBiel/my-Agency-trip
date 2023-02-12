package com.agencytravelboat.amazon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

//    private val db = Firebase.firestore
//    private val embarcacaoAdapter by lazy { EmbarcacaoAdapter(mutableListOf()) }
//    private val lista: MutableList<Embarcacao> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

    }


//    fun initRecyclerView(embarcacao: MutableList<Embarcacao>) {
//        val recycler by lazy { findViewById<RecyclerView>(R.id.recyclerViewListaEmbarcacao) }
//        recycler.adapter = embarcacaoAdapter
//        embarcacaoAdapter.setDataSet(embarcacao)
//        recycler.layoutManager = LinearLayoutManager(this)
//        embarcacaoAdapter.notifyDataSetChanged()
//
//    }
}