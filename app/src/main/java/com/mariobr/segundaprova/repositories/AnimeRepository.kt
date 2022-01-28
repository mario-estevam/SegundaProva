package com.mariobr.segundaprova.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mariobr.segundaprova.animes.Anime
import com.mariobr.segundaprova.animes.AnimeDAO

class AnimeRepository(private val animeDAO: AnimeDAO) {

    val animeList = animeDAO.listAll()

    suspend fun insert(anime:Anime) {
       animeDAO.inserir(anime)
    }

    fun find(id: Long): LiveData<Anime> {
        return this.animeDAO.findById(id.toInt()) as LiveData<Anime>
    }

    fun update(anime:Anime) {
        this.animeDAO.atualizar(anime)
    }

    fun delete(anime:Anime) {
        this.animeDAO.delete(anime)
    }

}


