package com.mariobr.segundaprova.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.mariobr.segundaprova.R
import com.mariobr.segundaprova.adapters.NovoAnimeAdapter
import com.mariobr.segundaprova.databinding.ListawebBinding
import com.mariobr.segundaprova.viewModels.AnimeViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class FragmentListweb : Fragment() {

    lateinit var binding: ListawebBinding
    private val viewModel: AnimeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.listaweb, container, false)
        val adapter  = NovoAnimeAdapter()
        binding.recyclerview2.adapter = adapter

        viewModel.buscarAnimes()!!.observe(viewLifecycleOwner, {
            val lista = it
            Log.e("objeto", lista.toString())
            adapter.notifyDataSetChanged()
        })


        return inflater.inflate(R.layout.listaweb, container, false)
    }



}