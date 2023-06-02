package castor.no.c.programar.nutriapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_actualizar_datos.txtIdPa
import kotlinx.android.synthetic.main.activity_actualizar_datos.txtPesos
import kotlinx.android.synthetic.main.activity_agregar_paciente.txtNacimiento
import kotlinx.coroutines.launch


class ActualizarDatos : AppCompatActivity() {

    lateinit var txtId: TextView
    lateinit var txtNombre: TextView
    lateinit var txtEdad: TextView
    lateinit var txtSexo: TextView
    lateinit var txtTelefono: TextView
    lateinit var txtFecha: TextView
    lateinit var txtPeso: TextView
    lateinit var txtEstatura: TextView
    lateinit var txtImc:TextView
    lateinit var txtPi:TextView
    lateinit var txtGet:TextView
    lateinit var txtGeb:TextView
    lateinit var txtPorcentaje: TextView
    lateinit var db :NutriApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_datos)
        supportActionBar?.hide()
        db = this.application as NutriApp
        txtId = findViewById(R.id.txtIdPa)
        txtNombre = findViewById(R.id.txtNombre)
        txtEdad = findViewById(R.id.txtEdad)
        txtSexo = findViewById(R.id.txtSexos)
        txtTelefono = findViewById(R.id.txtCelular)
        txtFecha = findViewById(R.id.txtFecha)
        txtPeso = findViewById(R.id.txtPesos)
        txtEstatura = findViewById(R.id.txtAltura)
        txtImc = findViewById(R.id.txtImc)
        txtPi = findViewById(R.id.txtPesoIde)
        txtGet = findViewById(R.id.txtGet)
        txtGeb = findViewById(R.id.txtGeb)
        txtPorcentaje = findViewById(R.id.txtPorcentajes)
        val id = intent.getIntExtra("idpacientes", 0)
        lifecycleScope.launch{
            val paciente = db.room.pacienteDao().getById(id)
            txtId.text = id.toString()
            txtNombre.text = paciente.nombre
            txtEdad.text = paciente.edad
            txtSexo.text = paciente.sexo
            txtEstatura.text = paciente.talla.toString()
            txtPeso.text = paciente.peso.toString()
            txtFecha.text = paciente.fecha
            txtTelefono.text = paciente.telefono
            txtImc.text = paciente.imc.toString()
            txtPi.text = paciente.pi.toString()
            txtGet.text = paciente.get.toString()
            txtGeb.text = paciente.geb.toString()
            txtPorcentaje.text = paciente.porcentaje.toString()
        }
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
        val id = txtId.text.toString().toInt()
        val nombre = txtNombre.text.toString().uppercase()
        val edad = txtEdad.text.toString()
        val sexo = txtSexo.text.toString()
        val telefono = txtTelefono.text.toString()
        val fecha = txtFecha.text.toString()
        val peso = txtPeso.text.toString().toDouble()
        val estatura = txtEstatura.text.toString().toDouble()
        val porcentaje = txtPorcentaje.text.toString().toInt()
        val imc = txtImc.text.toString().toDouble()
        val pi = txtPi.text.toString().toDouble()
        val get = txtGet.text.toString().toDouble()
        val geb = txtGeb.text.toString().toDouble()
        lifecycleScope.launch{
            val paciente = Pacientes(id, nombre, edad, sexo, telefono, fecha, peso, estatura, porcentaje, imc, pi, get, geb)
            db.room.pacienteDao().update(paciente)
        }
        Toast.makeText(this, "Datos Registrados", Toast.LENGTH_LONG).show()
        finish()
    }
}