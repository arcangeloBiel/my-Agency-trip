package com.agencytravelboat.amazon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.agencytravelboat.amazon.data.model.Embarcacao
import com.agencytravelboat.amazon.presentation.adapter.EmbarcacaoAdapter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private val db = Firebase.firestore
    private val embarcacaoAdapter by lazy { EmbarcacaoAdapter(mutableListOf()) }
    private val lista: MutableList<Embarcacao> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getProduto()
    }
    fun getProduto() {

        try {
            db.collection("Embarcacao")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        val post = document.toObject(Embarcacao::class.java)
                        lista.add(post)
                        initRecyclerView(lista)

                    }
                }
                .addOnFailureListener { exception ->
                    Log.w("teste", "Error getting documents.", exception)
                }

        } catch (ex: Exception) {
            Log.w("teste", "Error getting documents.", ex)
        }
    }

    fun initRecyclerView(embarcacao: MutableList<Embarcacao>) {
        val recycler by lazy { findViewById<RecyclerView>(R.id.recyclerViewListaEmbarcacao) }
        recycler.adapter = embarcacaoAdapter
        embarcacaoAdapter.setDataSet(embarcacao)
        recycler.layoutManager = LinearLayoutManager(this)
        embarcacaoAdapter.notifyDataSetChanged()

    }
}