package castor.no.c.programar.nutriapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_actualizar_datos.txtPesos
import kotlinx.android.synthetic.main.activity_agregar_paciente.txtNacimiento


class ActualizarDatos : AppCompatActivity() {

    lateinit var txtId: TextView
    lateinit var txtNombre: EditText
    lateinit var txtEdad: EditText
    lateinit var txtSexo: EditText
    lateinit var txtTelefono: EditText
    lateinit var txtFecha: EditText
    lateinit var txtPeso: EditText
    lateinit var txtEstatura: EditText
    lateinit var txtPorcentaje: EditText
    lateinit var db :NutriApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_datos)
        txtId = findViewById(R.id.txtIdPa)
        txtNombre = findViewById(R.id.txtNombre)
        txtEdad = findViewById(R.id.txtEdad)
        txtSexo = findViewById(R.id.txtSexos)
        txtTelefono = findViewById(R.id.txtCelular)
        txtFecha = findViewById(R.id.txtFecha)
        txtPeso = findViewById(R.id.txtPesos)
        txtEstatura = findViewById(R.id.txtAltura)
        txtPorcentaje = findViewById(R.id.txtPorcentajes)
        supportActionBar?.hide()
        db = this.application as NutriApp
        txtFecha.setOnClickListener { showDatePickerDialog() }
        txtFecha.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                showDatePickerDialog()
            }
        }
    }
    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment {day, month, year -> onDateSelected(day, month+1, year)}
        datePicker.show(supportFragmentManager, "datePicker")
    }
    fun onDateSelected(day:Int, month:Int, year:Int){
        txtFecha.setText("$day/$month/$year")
        txtPeso
            .requestFocus()
    }
    fun actualizarPacienteDatos(v: View){
        Toast.makeText(this, "Hago clic", Toast.LENGTH_LONG).show()
    }
}