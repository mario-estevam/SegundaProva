package com.mariobr.segundaprova.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.mariobr.segundaprova.R
import com.mariobr.segundaprova.dialogs.DialogSobre


class SobreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sobre, container, false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.saiba -> {
                val dialog = DialogSobre()
                dialog.show(requireActivity().supportFragmentManager,"Dialog5")
            }
        }
        return super.onOptionsItemSelected(item)
    }

}