package udl.eps.demos.navegadorcorreosmuyflexible_kotlin

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import udl.eps.demos.navegadorcorreosmuyflexible_kotlin.databinding.FragmentListadoBinding
import udl.eps.demos.navegadorcorreosmuyflexible_kotlin.databinding.ListitemCorreoBinding
import java.util.*

class FragmentListado : Fragment() {

    private val datos = arrayOf(
        Correo("Persona 1", "Asunto del correo 1", "Texto del correo 1"),
        Correo("Persona 2", "Asunto del correo 2", "Texto del correo 2"),
        Correo("Persona 3", "Asunto del correo 3", "Texto del correo 3"),
        Correo("Persona 4", "Asunto del correo 4", "Texto del correo 4"),
        Correo("Persona 5", "Asunto del correo 5", "Texto del correo 5")
    )

    private lateinit var lstListado: ListView


    private lateinit var binding: FragmentListadoBinding
    private var listener: CorreosListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListadoBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, state: Bundle?) {
        super.onViewCreated(view, state)
        lstListado = binding.LstListado
        lstListado.adapter = AdaptadorCorreos(this, datos)
        lstListado.setOnItemClickListener { list, view, pos, id ->
            if (listener != null) {
                listener!!.onCorreoSeleccionado(
                    lstListado.getAdapter().getItem(pos) as Correo
                )
            }
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = try {
            context as CorreosListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnCorreosListener")
        }
    }


    internal class AdaptadorCorreos(fragmentListado: FragmentListado, array: Array<Correo>) :
        ArrayAdapter<Correo?>(fragmentListado.requireActivity(), R.layout.listitem_correo, array) {
        var context: Activity?
        var datos: Array<Correo> = array
        @SuppressLint("ViewHolder")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val inflater = LayoutInflater.from(context)
            val binding = ListitemCorreoBinding.inflate(inflater, parent, false)
            val lblDe = binding.LblDe
            lblDe.text = datos[position].de
            val lblAsunto = binding.LblAsunto
            lblAsunto.text = datos[position].asunto
            return binding.root
        }
        init {
            context = fragmentListado.activity
        }
    }

    interface CorreosListener {
        fun onCorreoSeleccionado(c: Correo)
    }
    fun setCorreosListener(listener: CorreosListener?) {
        this.listener = listener
    }
 }