package castor.no.c.programar.nutriapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_agregar_paciente.*
import kotlinx.coroutines.launch

class AgregarPaciente : AppCompatActivity() {
    lateinit var txtNombre:EditText
    lateinit var txtEdad:EditText
    lateinit var txtSexo:EditText
    lateinit var txtTelefono:EditText
    lateinit var txtFecha:EditText
    lateinit var txtPeso:EditText
    lateinit var txtEstatura:EditText
    lateinit var txtPorcentaje:EditText
    lateinit var db :NutriApp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_paciente)
        txtNombre = findViewById(R.id.txtNom)
        txtEdad = findViewById(R.id.txtEdad)
        txtSexo = findViewById(R.id.txtSex)
        txtTelefono = findViewById(R.id.txtTelefono)
        txtFecha = findViewById(R.id.txtNacimiento)
        txtPeso = findViewById(R.id.txtPeso)
        txtEstatura = findViewById(R.id.txtEstatura)
        txtPorcentaje = findViewById(R.id.txtPA)
        db = this.application as NutriApp
        supportActionBar?.hide()
        txtNacimiento.setOnClickListener{showDatePickerDialog()}
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment {day, month, year -> onDateSelected(day, month+1, year)}
        datePicker.show(supportFragmentManager, "datePicker")
    }
    fun onDateSelected(day:Int, month:Int, year:Int){
        txtNacimiento.setText("$day/$month/$year")
    }
    fun agregarDatos(v: View) {
        //Aqui agrego
        try {
        val nombre = txtNombre.text.toString()
        val edad = txtEdad.text.toString()
        val sexo = txtSexo.text.toString()
        val telefono = txtTelefono.text.toString()
        val fecha = txtFecha.text.toString()
        val peso = txtPeso.text.toString().toDouble()
        val estatura = txtEstatura.text.toString().toDouble()
        val porcentaje = txtPorcentaje.text.toString().toInt()
        if (nombre.equals("") or edad.equals("") or sexo.equals("") or telefono.equals("") or fecha.equals("") or peso.equals("") or estatura.equals("") or porcentaje.equals("")){
            Toast.makeText(this, "Datos incompletos", Toast.LENGTH_LONG).show()
        }else{
            lifecycleScope.launch{
                val paciente = Pacientes(0, nombre, edad, sexo, telefono, fecha, peso, estatura, porcentaje,0.0,0.0,0.0, 0.0)
                db.room.pacienteDao().insert(paciente)
            }
            Toast.makeText(this, "Paciente Registrado", Toast.LENGTH_LONG).show()
            finish()
        }
        }catch (e: Exception){
            Toast.makeText(this, "Datos incompletos", Toast.LENGTH_LONG).show()
        }
    }
}