package castor.no.c.programar.nutriapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

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
        txtNombre = findViewById(R.id.txtNombre)
        txtEdad = findViewById(R.id.txtEdad)
        txtTelefono = findViewById(R.id.txtTelefono)
        txtFecha = findViewById(R.id.txtNacimiento)
        txtPeso = findViewById(R.id.txtPeso)
        txtEstatura = findViewById(R.id.txtEstatura)
        supportActionBar?.hide()
    }

}