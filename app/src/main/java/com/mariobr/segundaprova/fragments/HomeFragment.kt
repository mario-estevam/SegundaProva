package com.mariobr.segundaprova.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
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
import com.mariobr.segundaprova.dialogs.CustomDialogFragment
import com.mariobr.segundaprova.dialogs.DialogHome
import com.mariobr.segundaprova.viewModels.HomeFragmentViewModel


@SuppressLint("UseRequireInsteadOfGet")
class HomeFragment : Fragment() {

    lateinit var binding:FragmentHomeBinding
    lateinit var viewModel: HomeFragmentViewModel

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)

        val adapter  = NovoAnimeAdapter()

        viewModel.listaAnimes?.observe(viewLifecycleOwner, {
            adapter.animes = it
            adapter.notifyDataSetChanged()
        })

        binding.recyclerview.adapter = adapter
        val layout = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerview.layoutManager = layout
        binding.recyclerview.addOnItemTouchListener(NovoRecyclerViewClickListener(context!!,binding.recyclerview, object : NovoRecyclerViewClickListener.onItemClickListener{
            override fun onItemClick(v: View, position: Int) {
                Navigation.findNavController(v).navigate(HomeFragmentDirections.actionHomeFragmentToDetalhesFragment(adapter.animes[position].id.toLong()))
            }
            override fun onItemLongClick(v: View, position: Int) {
                Navigation.findNavController(v).navigate(HomeFragmentDirections.actionHomeFragmentToAlteraFragment(adapter.animes[position].id.toLong()))
            }
        }))
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.saiba -> {
                val dialog = DialogHome()
                dialog.show(requireActivity().supportFragmentManager,"Dialog3")
            }
        }
        return super.onOptionsItemSelected(item)
    }
}