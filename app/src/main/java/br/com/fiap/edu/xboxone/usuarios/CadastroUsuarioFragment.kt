package br.com.fiap.edu.xboxone.usuarios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.fiap.edu.xboxone.XboxApplication
import br.com.fiap.edu.xboxone.databinding.FragmentEdituserBinding

class CadastroUsuarioFragment: Fragment() {

    private var _binding: FragmentEdituserBinding? = null
    private val binding get() = _binding!!

    private var model = UsuariosModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEdituserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        setupUI()
        setTextFieldUserUI()
        setBtnVoltarUI()
        setBtnRegistrarUI()
        setBtnExcluirUI()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setTextFieldUserUI() {
        val user = arguments?.getString("usuario")
        binding.edtEmail.setText(user)
    }
    private fun setBtnRegistrarUI() {
        binding.btnRegistrar.setOnClickListener{
            model.atualizarUsuario(usuario = binding.edtEmail.text)
        }
    }
    private fun setBtnVoltarUI() {
        binding.btnVoltar.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
    private fun setBtnExcluirUI(){
        binding.btnExcluir.setOnClickListener{
            model.deleteUsuario(usuario = arguments?.getString("usuario"))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val usuario = arguments?.getString("usuario")
        if(usuario == null) {

        } else {
            val customUser = XboxApplication.database.getUserDao().getUsuario(usuario)
            println(customUser)
        }


    }

}