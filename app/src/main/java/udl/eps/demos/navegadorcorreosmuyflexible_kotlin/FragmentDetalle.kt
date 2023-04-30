package udl.eps.demos.navegadorcorreosmuyflexible_kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import udl.eps.demos.navegadorcorreosmuyflexible_kotlin.databinding.FragmentDetalleBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentDetalle.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentDetalle : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentDetalleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentDetalleBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun mostrarDetalle(texto: String?) {
        val txtDetalle = binding.TxtDetalle
        txtDetalle.text = texto
    }

}