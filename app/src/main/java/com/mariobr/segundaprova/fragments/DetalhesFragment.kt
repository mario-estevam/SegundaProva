package com.mariobr.segundaprova.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import androidx.room.Room
import com.mariobr.segundaprova.R
import com.mariobr.segundaprova.animes.AppDatabase
import com.mariobr.segundaprova.databinding.FragmentDetalhesBinding



@SuppressLint("UseRequireInsteadOfGet")
class DetalhesFragment : Fragment() {

    val db: AppDatabase by lazy{
        Room.databaseBuilder(
            context!!,
            AppDatabase::class.java, "database-name")
            .allowMainThreadQueries()
            .build()
    }

    lateinit var binding:FragmentDetalhesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_detalhes, container, false)
        // Inflate the layout for this fragment
        val args:DetalhesFragmentArgs by navArgs()
        val x = args.id + 1
        val encontrarAnime  = db.animeDao().findById(x.toInt())
        binding.editTextnome.text = encontrarAnime.nome
        binding.editTextTexteps.text = encontrarAnime.eps.toString()
        binding.editTextArcos.text = encontrarAnime.arcos
        binding.editTextAno.text = encontrarAnime.ano.toString()
        binding.editTextIdioma.text = encontrarAnime.idioma
        binding.editTextTextClassificacao.text = encontrarAnime.classificacao.toString()
        setHasOptionsMenu(true)
        return binding.root
    }
}