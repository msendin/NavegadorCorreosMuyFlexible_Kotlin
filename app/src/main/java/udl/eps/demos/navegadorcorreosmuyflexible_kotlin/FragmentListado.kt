package udl.eps.demos.navegadorcorreosmuyflexible_kotlin

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import udl.eps.demos.navegadorcorreosmuyflexible_kotlin.databinding.FragmentListadoBinding
import udl.eps.demos.navegadorcorreosmuyflexible_kotlin.databinding.ListitemCorreoBinding
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentListado.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentListado : Fragment() {

    private val datos = arrayOf(
        Correo("Persona 1", "Asunto del correo 1", "Texto del correo 1"),
        Correo("Persona 2", "Asunto del correo 2", "Texto del correo 2"),
        Correo("Persona 3", "Asunto del correo 3", "Texto del correo 3"),
        Correo("Persona 4", "Asunto del correo 4", "Texto del correo 4"),
        Correo("Persona 5", "Asunto del correo 5", "Texto del correo 5")
    )

    private lateinit var lstListado: ListView //? = null

    private var listener: CorreosListener? = null

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentListadoBinding


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
            val inflater = context!!.layoutInflater // LayoutInflater.from(context)
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