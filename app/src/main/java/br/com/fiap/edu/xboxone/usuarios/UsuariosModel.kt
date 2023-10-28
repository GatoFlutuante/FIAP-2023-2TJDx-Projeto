package br.com.fiap.edu.xboxone.usuarios

import android.text.Editable
import br.com.fiap.edu.xboxone.XboxApplication

class UsuariosModel {

    private val database = XboxApplication.database
    fun atualizarUsuario(usuario: Editable): Boolean {
        val user = database.getUserDao().getUsuario(usuario.toString())
        database.getUserDao().updateUsuario(user)
        return true
    }
    fun deleteUsuario(usuario: String?) {
        val user = database.getUserDao().getUsuario(usuario.toString())
        database.getUserDao().deletarUsuario(user)
    }
}