package com.agencytravelboat.amazon.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.agencytravelboat.amazon.R
import com.agencytravelboat.amazon.data.model.Embarcacao
import com.bumptech.glide.Glide

class EmbarcacaoAdapter(private var dataSet: MutableList<Embarcacao>
) : RecyclerView.Adapter<EmbarcacaoAdapter.ViewHolder>() {

   // var clickListener: ItemClickListener? = null

//    fun itemClickListener(itemClickListener: ItemClickListener) {
//        this.clickListener = itemClickListener
//    }

    fun setDataSet(dados: MutableList<Embarcacao>) {
        this.dataSet = dados
    }

    fun limparDados() {
        val size: Int = dataSet.size
        dataSet.clear()
        notifyItemRangeRemoved(0, size)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        val nome: TextView = itemView.findViewById(R.id.idNome)
        val descricao: TextView = itemView.findViewById(R.id.IdDescricao)
        val cidade: TextView = itemView.findViewById(R.id.IdCidade)
        val imgUrl: ImageView = itemView.findViewById(R.id.idImage)

        override fun onClick(v: View?) {
            //clickListener?.onItemClick(v!!, layoutPosition)
        }

        init {
            itemView.setOnClickListener(this)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_embarcacao, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {

            holder.nome.text = dataSet[position].Nome
            holder.cidade.text = ("Cidade: ${dataSet[position].Cidade}")
            holder.descricao.text = dataSet[position].Descricao
            try {
                val imageItem = dataSet[position].ImagemUrl
                if (imageItem != null) {
                    Glide.with(holder.itemView)
                        .load("${dataSet[position].ImagemUrl}")
                        .into(holder.imgUrl)
                } else {
                    holder.imgUrl.setImageResource(R.drawable.ic_launcher_background)
                }
            } catch (e: Exception) {
                holder.imgUrl.setImageResource(R.drawable.ic_launcher_background)
            }

        }catch(e: Exception){
        }
    }

}