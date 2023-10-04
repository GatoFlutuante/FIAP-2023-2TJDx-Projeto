package br.com.fiap.edu.xboxone.login

import br.com.fiap.edu.xboxone.XboxApplication

class LoginModel {

    private val database = XboxApplication.database

    /* valida se é um usuario valido */
    fun validateUsername(usuario: String): Boolean {
        val username = usuario.lowercase()

        val usuario = database.getUserDao().hasUsuario(username)
        return usuario != null
    }
}