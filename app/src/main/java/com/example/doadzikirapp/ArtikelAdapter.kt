package com.example.doadzikirapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ArtikelAdapter(private val listArtikel: ArrayList<Artikel>):
    RecyclerView.Adapter<ArtikelAdapter.MyViewHolder>(){

    // tidak menggunakan inner juga tidak apa
    // versi baru kadang harus menggunakan inner
    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imgArtikel: ImageView = view.findViewById(R.id.img_artikel)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_item_artikel, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ArtikelAdapter.MyViewHolder, position: Int) {
        holder.imgArtikel.setImageResource(listArtikel[position].imageArtikel)
        holder.imgArtikel.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailArtikel::class.java)
            intent.putExtra(DetailArtikel.DATA_TITLE, listArtikel[position].titleArtikel)
            intent.putExtra(DetailArtikel.DATA_DESC, listArtikel[position].descArtikel)
            intent.putExtra(DetailArtikel.DATA_IMG, listArtikel[position].imageArtikel)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
       return listArtikel.size
    }
}