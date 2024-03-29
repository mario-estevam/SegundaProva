package com.mariobr.segundaprova.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mariobr.segundaprova.R

import com.mariobr.segundaprova.animes.Anime

class NovoAnimeAdapter : RecyclerView.Adapter<NovoAnimeViewHolder>() {

    var animes:List<Anime> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NovoAnimeViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.anime_inflater, parent, false)
        val holder = NovoAnimeViewHolder(v)
        return holder
    }

    override fun onBindViewHolder(holder: NovoAnimeViewHolder, position: Int) {
        val animeEscolhido = animes.get(position)
        holder.nota.text = animeEscolhido.nota.toString()
        holder.nomeAnime.text = animeEscolhido.nome
        holder.eps.text = animeEscolhido.eps.toString()
    }

    override fun getItemCount(): Int {
        return animes.size
    }

}

class NovoAnimeViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val nota = v.findViewById<TextView>(R.id.nota)
    val nomeAnime = v.findViewById<TextView>(R.id.nomeAnime)
    val eps = v.findViewById<TextView>(R.id.eps)
}