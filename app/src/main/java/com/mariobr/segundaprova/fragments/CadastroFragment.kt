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
import androidx.room.Room
import com.mariobr.segundaprova.R
import com.mariobr.segundaprova.animes.Anime
import com.mariobr.segundaprova.animes.AppDatabase
import com.mariobr.segundaprova.databinding.FragmentCadastroBinding
import com.mariobr.segundaprova.viewModels.CadastroViewModel

lateinit var bindingCadastro:FragmentCadastroBinding

@SuppressLint("UseRequireInsteadOfGet")
class CadastroFragment : Fragment() {
    lateinit var viewModel: CadastroViewModel

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
        bindingCadastro= DataBindingUtil.inflate(inflater, R.layout.fragment_cadastro, container, false)
        viewModel = ViewModelProvider(this,).get(CadastroViewModel::class.java)
        bindingCadastro.cadastrar.setOnClickListener {
            viewModel.setAtrributes()
            db.animeDao().inserir(Anime(viewModel.nome,viewModel.arcos, viewModel.eps, viewModel.nota,viewModel.classificacao))
            Navigation.findNavController(it).navigate(R.id.homeFragment)
            Toast.makeText(context, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show()
        }
        setHasOptionsMenu(true)
        return bindingCadastro.root
    }

}