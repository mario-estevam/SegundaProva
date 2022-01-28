package com.mariobr.segundaprova.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
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
        val x = args.id
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



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.saiba -> Toast.makeText(context, "tela de exibição de detalhes do anime selecionado", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

}