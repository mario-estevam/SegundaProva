package com.mariobr.segundaprova.viewModels

import android.app.Application
import androidx.lifecycle.*
import com.mariobr.segundaprova.animes.Anime
import com.mariobr.segundaprova.animes.AppDatabase
import kotlinx.coroutines.launch


class AlteraViewModel(application: Application,  id:Int) : AndroidViewModel(application) {

    val animeDAO = AppDatabase.getDatabase(application).animeDao()

    lateinit var anime: LiveData<Anime>

    init {
        viewModelScope.launch {
            anime =  animeDAO.buscarPorId(id)
        }
    }


    fun saveAnime() {
        viewModelScope.launch {
         animeDAO.atualizar(anime.value!!)
        }
    }


    class AlteraFragmentViewModelFactory(val application: Application, val id:Int) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AlteraViewModel::class.java)) {
                return AlteraViewModel(application, id) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }




}
