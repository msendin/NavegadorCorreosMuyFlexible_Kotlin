package udl.eps.demos.navegadorcorreosmuyflexible_kotlin

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class DetalleActivity : FragmentActivity() {
    val EXTRA_TEXTO = "cat.udl.eps.fragments.ejmoreflexible.EXTRA_TEXTO"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)
        val detalle = supportFragmentManager
            .findFragmentById(R.id.FrgDetalle) as FragmentDetalle?
        detalle?.mostrarDetalle(intent.getStringExtra(EXTRA_TEXTO))
    }
}