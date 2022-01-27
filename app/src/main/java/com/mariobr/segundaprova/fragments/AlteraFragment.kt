package com.mariobr.segundaprova.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.room.Room
import com.mariobr.segundaprova.R
import com.mariobr.segundaprova.animes.AppDatabase
import com.mariobr.segundaprova.databinding.FragmentAlteraBinding
import com.mariobr.segundaprova.viewModels.AlteraViewModel

lateinit var bindingAltera:FragmentAlteraBinding
@SuppressLint("UseRequireInsteadOfGet")
class AlteraFragment : Fragment() {

    lateinit var viewModelAltera:AlteraViewModel
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
        bindingAltera= DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)
        viewModelAltera = ViewModelProvider(this,).get(AlteraViewModel::class.java)
        bindingAltera.alteraViewModel = viewModelAltera
        val args:AlteraFragmentArgs by navArgs()
        val x = args.id + 1
        viewModelAltera.findByid(x.toInt())
        bindingAltera.alterar.setOnClickListener {
            viewModelAltera.saveAnime()
            Navigation.findNavController(it).navigate(R.id.homeFragment)
            Toast.makeText(context, "Dados alterados com sucesso!", Toast.LENGTH_SHORT).show()
        }

        setHasOptionsMenu(true)
        return bindingAltera.root
    }

}