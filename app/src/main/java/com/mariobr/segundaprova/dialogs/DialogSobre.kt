package com.mariobr.segundaprova.dialogs

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.mariobr.segundaprova.R

class DialogSobre: DialogFragment() {

    @SuppressLint("InlinedApi")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it, android.R.style.Theme_Material_Dialog_MinWidth)
            builder
                .setIcon(android.R.drawable.ic_dialog_info)
                .setTitle(getString(R.string.tela_sobre))
                .setMessage("Aqui você pode ter acesso às informações do desenvolvedor do aplicativo")
                .setPositiveButton("Confirmar",
                    DialogInterface.OnClickListener { dialog, id ->
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}