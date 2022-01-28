package com.mariobr.segundaprova.viewModels

import AlteraViewModel
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.mariobr.segundaprova.animes.Anime
import com.mariobr.segundaprova.animes.AppDatabase
import com.mariobr.segundaprova.repositories.AnimeRepository

class AlteraViewModelFactory(val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlteraViewModel::class.java)) {
            return AlteraViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
    
    val animeDAO = AppDatabase.getDatabase(context).animeDao()

    var animeId = MutableLiveData<Int>(null)
    var nome = MutableLiveData<String>()
    var arcos = MutableLiveData<String>()
    var eps  = MutableLiveData(0)
    var ano = MutableLiveData<Int>(0)
    var idiomas  = MutableLiveData<String>()
    var classificacao = MutableLiveData(0)



    var anime: Anime
        get() {
            val animeReturn = Anime(
                nome.value!!,
                arcos.value!!,
                eps.value!!,
                ano.value!!,
                idiomas.value!!,
                classificacao.value!!
            )
            animeReturn.id = animeId.value!!
            return animeReturn
        }
        set(anime) {
            animeId.value = anime.id
            nome.value = anime.nome
            arcos.value =anime.arcos
            eps.value = anime.eps
            ano.value = anime.ano
            idiomas.value = anime.idioma
            classificacao.value = anime.classificacao
        }

    fun findByid(id:Int){
        val animeEncontrado = animeDAO.findById(id)
        anime = animeEncontrado
    }

    fun saveAnime() {
        animeDAO.atualizar(anime)
    }


}