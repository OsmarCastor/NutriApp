package castor.no.c.programar.nutriapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_agregar_paciente.*
import kotlinx.coroutines.launch

class agregarPaciente : AppCompatActivity() {
    lateinit var txtNombre:EditText
    lateinit var txtEdad:EditText
    lateinit var txtTelefono:EditText
    lateinit var txtFecha:EditText
    lateinit var txtPeso:EditText
    lateinit var txtEstatura:EditText
    lateinit var txtPorcentaje:EditText
    /*lateinit var rbSedentario:RadioButton
    lateinit var rbLigero:RadioButton
    lateinit var rbModerado:RadioButton
    lateinit var rbPesado:RadioButton
    lateinit var porcentaje:String
     */
    lateinit var db :NutriApp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_paciente)
        txtNombre = findViewById(R.id.txtNom)
        txtEdad = findViewById(R.id.txtEdad)
        txtTelefono = findViewById(R.id.txtTelefono)
        txtFecha = findViewById(R.id.txtNacimiento)
        txtPeso = findViewById(R.id.txtPeso)
        txtEstatura = findViewById(R.id.txtEstatura)
        txtPorcentaje = findViewById(R.id.txtPA)
        /*rbSedentario = findViewById(R.id.rbSedentario)
        rbLigero = findViewById(R.id.rbLigero)
        rbModerado = findViewById(R.id.rbModerado)
        rbPesado = findViewById(R.id.rbPesado)
         */
        db = this.application as NutriApp
        supportActionBar?.hide()
        txtNacimiento.setOnClickListener{showDatePickerDialog()}
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment {day, month, year -> onDateSelected(day, month, year)}
        datePicker.show(supportFragmentManager, "datePicker")
    }
    fun onDateSelected(day:Int, month:Int, year:Int){
        txtNacimiento.setText("$day/$month/$year")
    }

    fun agregarDatos(v: View) {
        //Aqui agrego
        val nombre = txtNombre.text.toString()
        val edad = txtEdad.text.toString()
        val telefono = txtTelefono.text.toString()
        val fecha = txtFecha.text.toString()
        val peso = txtPeso.text.toString()
        val estatura = txtEstatura.text.toString()
        val porcentaje = txtPorcentaje.text.toString().toInt()
        /*if (rbSedentario.isChecked == true){
            porcentaje = rbSedentario.text.toString()
        }else{
            if (rbLigero.isChecked == true){
                porcentaje = rbLigero.text.toString()

            }else{
                if (rbModerado.isChecked == true){
                    porcentaje = rbModerado.text.toString()
                }else{
                    porcentaje = rbPesado.text.toString()
                }
            }
        }
         */
        lifecycleScope.launch{
            val paciente = Pacientes(0, nombre, edad, telefono, fecha, peso, estatura, porcentaje,"NA","NA","NA")
            db.room.pacienteDao().insert(paciente)
        }
        Toast.makeText(this, "Paciente Registrado", Toast.LENGTH_LONG).show()
        finish()
    }

}