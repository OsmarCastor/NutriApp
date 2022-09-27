package castor.no.c.programar.nutriapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class agregarPaciente : AppCompatActivity() {
    lateinit var txtNombre:EditText
    lateinit var txtEdad:EditText
    lateinit var txtTelefono:EditText
    lateinit var txtFecha:EditText
    lateinit var txtPeso:EditText
    lateinit var txtEstatura:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_paciente)
        txtNombre = findViewById(R.id.txtNom)
        txtEdad = findViewById(R.id.txtEdad)
        txtTelefono = findViewById(R.id.txtTelefono)
        txtFecha = findViewById(R.id.txtNacimiento)
        txtPeso = findViewById(R.id.txtPeso)
        txtEstatura = findViewById(R.id.txtEstatura)
        supportActionBar?.hide()
    }
    fun agregarDatos(v: View) {
        //Aqui hago la lectura de los campos de texto
        val nombre = txtNombre.text.toString()
        val edad = txtEdad.text.toString()
        val telefono = txtTelefono.text.toString()
        val fecha = txtFecha.text.toString()
        val peso = txtPeso.text.toString()
        val estatura = txtEstatura.text.toString()
        val persona = paciente(nombre, edad, telefono, fecha, peso, estatura)
        mostrarPaciente.pacientes.add(persona)
        Toast.makeText(this, "Se agrego un paciente", Toast.LENGTH_LONG).show()
        finish()
    }

}