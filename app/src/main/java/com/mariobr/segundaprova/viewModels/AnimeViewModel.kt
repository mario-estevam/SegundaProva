package com.mariobr.segundaprova.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mariobr.segundaprova.animes.Anime
import com.mariobr.segundaprova.repository.AnimeRepository
import com.mariobr.segundaprova.repository.Resultado

class AnimeViewModel(private val repository: AnimeRepository) : ViewModel() {

    fun buscarAnimeByID(id:Long): LiveData<Resultado<Anime?>> =
        repository.buscaAnime(id)

    fun buscarAnimes(): LiveData<Resultado<List<List<Anime>?>>> {
        return repository.buscaAnimes()
    }
}