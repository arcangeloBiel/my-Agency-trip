package com.agencytravelboat.amazon.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.agencytravelboat.amazon.data.model.Embarcacao
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class EmbarcacaoRepository {

    private val database = Firebase.firestore
    private val newsFeedReference = database.collection("Embarcacao")


    fun fetchVessels(liveData: MutableLiveData<List<Embarcacao>>) {
        newsFeedReference.get().addOnSuccessListener{ ValueEventListener ->
            for (document in ValueEventListener) {
                val post = document.toObject(Embarcacao::class.java)
                  liveData.postValue(mutableListOf(post))

            }
        }
    }
}