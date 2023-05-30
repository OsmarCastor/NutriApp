package castor.no.c.programar.nutriapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class ActualizarDatos : AppCompatActivity() {

    lateinit var txtId: TextView
    lateinit var txtNombre: TextView
    lateinit var txtEdad: TextView
    lateinit var txtSexo: TextView
    lateinit var txtTelefono: TextView
    lateinit var txtFecha: TextView
    lateinit var txtPeso: TextView
    lateinit var txtEstatura: TextView
    lateinit var txtPorcentaje: TextView
    lateinit var txtImc: TextView
    lateinit var txtPi: TextView
    lateinit var txtGet: TextView
    lateinit var txtGeb: TextView
    lateinit var db :NutriApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_datos)
        supportActionBar?.hide()
        db = this.application as NutriApp
    }
}