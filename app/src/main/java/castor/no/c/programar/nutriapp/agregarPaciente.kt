package castor.no.c.programar.nutriapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast

class agregarPaciente : AppCompatActivity() {
    lateinit var txtNombre:EditText
    lateinit var txtEdad:EditText
    lateinit var txtTelefono:EditText
    lateinit var txtFecha:EditText
    lateinit var txtPeso:EditText
    lateinit var txtEstatura:EditText
    lateinit var rbSedentario:RadioButton
    lateinit var rbLigero:RadioButton
    lateinit var rbModerado:RadioButton
    lateinit var rbPesado:RadioButton
    lateinit var porcentaje:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_paciente)
        txtNombre = findViewById(R.id.txtNom)
        txtEdad = findViewById(R.id.txtEdad)
        txtTelefono = findViewById(R.id.txtTelefono)
        txtFecha = findViewById(R.id.txtNacimiento)
        txtPeso = findViewById(R.id.txtPeso)
        txtEstatura = findViewById(R.id.txtEstatura)
        rbSedentario = findViewById(R.id.rbSedentario)
        rbLigero = findViewById(R.id.rbLigero)
        rbModerado = findViewById(R.id.rbModerado)
        rbPesado = findViewById(R.id.rbPesado)
        supportActionBar?.hide()
    }
    fun agregarDatos(v: View) {
        //Aqui agrego
        val nombre = txtNombre.text.toString()
        val edad = txtEdad.text.toString()
        val telefono = txtTelefono.text.toString()
        val fecha = txtFecha.text.toString()
        val peso = txtPeso.text.toString()
        val estatura = txtEstatura.text.toString()
        if (rbSedentario.isChecked == true){
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
        val paciente = Pacientes(1, nombre, edad, telefono, fecha, peso, estatura, porcentaje)
        val dao = PacientesApp()
        dao.room.pacienteDao().insert(paciente)
        //mostrarPaciente.pacientes.add(Adaptador)
        Toast.makeText(this, "Se agrego un paciente", Toast.LENGTH_LONG).show()
        finish()
    }

}