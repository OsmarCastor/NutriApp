package castor.no.c.programar.nutriapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton

class formularioPacientes : AppCompatActivity() {
    lateinit var txtNombre:EditText
    lateinit var txtEdad:EditText
    lateinit var txtTelefono:EditText
    lateinit var txtFecha:EditText
    lateinit var txtPeso:EditText
    lateinit var txtEstatura:EditText
    lateinit var txtPorcentaje:EditText
    lateinit var db :NutriApp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_pacientes)
        db = this.application as NutriApp
        supportActionBar?.hide()

    }
    fun salir(v: View) {
        finish()
    }
    fun guardarBD(v: View){
    }
    fun hacerIMC(v: View){
    }
    fun hacerPI(v: View){
    }
    fun hacerGET(v: View){
    }
}