package com.mariobr.segundaprova.viewModels

import android.app.Application
import androidx.lifecycle.*
import com.mariobr.segundaprova.animes.Anime
import com.mariobr.segundaprova.animes.AppDatabase

import kotlinx.coroutines.launch

class DetalhesViewModel(application: Application, id: Int) : AndroidViewModel(application)  {

    lateinit var anime:LiveData<Anime>
    val animeDAO = AppDatabase.getDatabase(application).animeDao()

    init {
        viewModelScope.launch {
            anime = animeDAO.buscarPorId(id)
        }
    }


    class DetalhesFragmentViewModelFactory(val application: Application, val id:Int) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetalhesViewModel::class.java)) {
                return DetalhesViewModel(application, id) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}

