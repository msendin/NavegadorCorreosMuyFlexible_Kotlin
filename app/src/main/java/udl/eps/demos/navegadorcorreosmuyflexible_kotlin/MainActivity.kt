package udl.eps.demos.navegadorcorreosmuyflexible_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import udl.eps.demos.navegadorcorreosmuyflexible_kotlin.databinding.ActivityMainBinding

class MainActivity : FragmentActivity(), FragmentListado.CorreosListener {
    val EXTRA_TEXTO = "cat.udl.eps.fragments.ejmoreflexible.EXTRA_TEXTO"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val frgListado = supportFragmentManager
            .findFragmentById(R.id.FrgListado) as FragmentListado?
        frgListado?.setCorreosListener(this)
    }


    override fun onCorreoSeleccionado(c: Correo) {
        val fgdet = supportFragmentManager.findFragmentById(R.id.FrgDetalle) as FragmentDetalle?
        val hayDetalle = fgdet != null && fgdet.isInLayout
        if (hayDetalle) {
            fgdet!!.mostrarDetalle(c.texto)
        } else {
            val i = Intent(this, DetalleActivity::class.java)
            i.putExtra(EXTRA_TEXTO, c.texto)
            startActivity(i)
        }
    }
}