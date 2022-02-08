package com.mariobr.segundaprova.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE

import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.mariobr.segundaprova.viewModels.AnimeViewModel
import com.google.android.material.snackbar.Snackbar
import com.mariobr.segundaprova.R
import com.mariobr.segundaprova.animes.Anime
import com.mariobr.segundaprova.databinding.FragmentRetrofitBinding
import com.mariobr.segundaprova.repository.Resultado
import com.mariobr.segundaprova.repository.Resultado2
import org.koin.android.viewmodel.ext.android.viewModel


class FragmentRetrofit : Fragment() {

    private val viewModel: AnimeViewModel by viewModel()
    lateinit var binding: FragmentRetrofitBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_retrofit, container, false)


       binding.botaoBuscar.setOnClickListener {
           val x = binding.buscarId.text.toString()
           val id  = x.toLong()
           buscaAnime(id)
       }

        setHasOptionsMenu(true)
        return binding.root
    }


    private fun buscaAnime(id: Long) {
        binding.progresso.show()
        viewModel.buscarAnimeByID(id).observe(viewLifecycleOwner) {
            binding.progresso.hide()
            val animeVisivel = it?.let { resultado ->
                when (resultado) {
                    is Resultado.Sucesso -> {
                        resultado.dado?.let { anime ->
                            preencheAnime(anime)
                            true
                        } ?: false
                    }
                    is Resultado.Erro -> {
                        Snackbar.make(
                            binding.coordinatorLayout,
                            resultado.exception.message.toString(),
                            Snackbar.LENGTH_SHORT
                        ).show()
                        false
                    }
                    is Resultado2.Erro -> TODO()
                    is Resultado2.Sucesso<*> -> TODO()
                }
            } ?: false

            binding.constraintLayoutInfoEndereco.visibility =
                if (animeVisivel) {
                    VISIBLE
                } else {
                    GONE
                }
        }
    }

    private fun preencheAnime(anime:Anime) {
        binding.nome.text = anime.nome
        binding.anoRetro.text = anime.ano.toString()
        binding.idiomaRetro.text = anime.idioma
        binding.arcosRetro.text = anime.arcos
        binding.episodios.text = anime.eps.toString()
        binding.classificRetro.text = anime.classificacao.toString()
    }




}