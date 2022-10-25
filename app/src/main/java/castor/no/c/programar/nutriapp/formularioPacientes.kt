package castor.no.c.programar.nutriapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class formularioPacientes : AppCompatActivity() {
    lateinit var txtId:TextView
    lateinit var txtNombre:TextView
    lateinit var txtEdad:TextView
    lateinit var txtTelefono:TextView
    lateinit var txtFecha:TextView
    lateinit var txtPeso:TextView
    lateinit var txtEstatura:TextView
    lateinit var txtPorcentaje:TextView
    lateinit var txtImc:TextView
    lateinit var txtPi:TextView
    lateinit var txtGet:TextView
    lateinit var db :NutriApp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_pacientes)
        db = this.application as NutriApp
        supportActionBar?.hide()
        txtId = findViewById(R.id.txtIdPaciente)
        txtNombre = findViewById(R.id.txtNomPaciente)
        txtEdad = findViewById(R.id.txtEdadPaciente)
        txtTelefono = findViewById(R.id.txtTelPaciente)
        txtFecha = findViewById(R.id.txtFechaPaciente)
        txtPeso = findViewById(R.id.txtPesoPaciente)
        txtEstatura = findViewById(R.id.txtEsPaciente)
        txtPorcentaje = findViewById(R.id.txtPorPaciente)
        txtImc = findViewById(R.id.txtImcPaciente)
        txtPi = findViewById(R.id.txtPiPaciente)
        txtGet = findViewById(R.id.txtGetPAciente)
        val id = intent.getIntExtra("idpaciente", 0)
        lifecycleScope.launch{
            val paciente = db.room.pacienteDao().getById(id)
            txtId.text = id.toString()
            txtNombre.text = paciente.nombre
            txtEdad.text = paciente.edad
            txtEstatura.text = paciente.talla.toString()
            txtPeso.text = paciente.peso.toString()
            txtFecha.text = paciente.fecha
            txtTelefono.text = paciente.telefono
            txtImc.text = paciente.imc.toString()
            txtPi.text = paciente.pi.toString()
            txtGet.text = paciente.get.toString()
            txtPorcentaje.text = paciente.porcentaje.toString()
        }
    }
    fun salir(v: View) {
        finish()
    }
    fun guardarBD(v: View){
        val id = txtId.text.toString().toInt()
        val nombre = txtNombre.text.toString()
        val edad = txtEdad.text.toString()
        val telefono = txtTelefono.text.toString()
        val fecha = txtFecha.text.toString()
        val peso = txtPeso.text.toString().toDouble()
        val estatura = txtEstatura.text.toString().toDouble()
        val porcentaje = txtPorcentaje.text.toString().toInt()
        val imc = txtImc.text.toString().toDouble()
        val pi = txtPi.text.toString().toDouble()
        val get = txtGet.text.toString().toDouble()
        lifecycleScope.launch{
            val paciente = Pacientes(id, nombre, edad, telefono, fecha, peso, estatura, porcentaje, imc, pi, get)
            db.room.pacienteDao().update(paciente)
        }
        Toast.makeText(this, "Datos Registrados", Toast.LENGTH_LONG).show()
        finish()
    }
    fun hacerIMC(v: View){
        //Aqui hacer operacion de peso*(altura)^2
        val peso = txtPeso.text.toString().toDouble()
        val estatura = txtEstatura.text.toString().toDouble()
        val exponente = 2
        val potencia = Math.pow(estatura, exponente.toDouble())
        var res = peso/(potencia)
        val imc = res*10000
        txtImc.text = imc.toString()
    }
    fun hacerPI(v: View){
        //Aqui hacer PI
        val estatura = txtEstatura.text.toString().toDouble()
        val pi = (50+(.75+(estatura-150)))
        txtPi.text = pi.toString()
    }
    fun hacerGET(v: View){
    }
}