package com.mariobr.segundaprova.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import com.mariobr.segundaprova.R
import com.mariobr.segundaprova.adapters.NovoAnimeAdapter
import com.mariobr.segundaprova.adapters.NovoRecyclerViewClickListener
import com.mariobr.segundaprova.animes.Anime
import com.mariobr.segundaprova.animes.AppDatabase
import com.mariobr.segundaprova.databinding.FragmentHomeBinding


@SuppressLint("UseRequireInsteadOfGet")
class HomeFragment : Fragment() {

    lateinit var binding:FragmentHomeBinding

    val db: AppDatabase by lazy{
        Room.databaseBuilder(
            context!!,
            AppDatabase::class.java, "database-name")
            .allowMainThreadQueries()
            .build()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        val adapter  = NovoAnimeAdapter()
        val listaAnimes = db.animeDao().listAllAdapter()
        adapter.animes = listaAnimes
        binding.recyclerview.adapter = adapter
        val layout = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerview.layoutManager = layout
        binding.recyclerview.addOnItemTouchListener(NovoRecyclerViewClickListener(context!!,binding.recyclerview, object : NovoRecyclerViewClickListener.onItemClickListener{
            override fun onItemClick(v: View, position: Int) {
                Navigation.findNavController(v).navigate(HomeFragmentDirections.actionHomeFragmentToDetalhesFragment(listaAnimes[position].id.toLong()))
            }
            override fun onItemLongClick(v: View, position: Int) {
                Navigation.findNavController(v).navigate(HomeFragmentDirections.actionHomeFragmentToAlteraFragment(listaAnimes[position].id.toLong()))
            }
        }))
        setHasOptionsMenu(true)
        return binding.root
    }

}