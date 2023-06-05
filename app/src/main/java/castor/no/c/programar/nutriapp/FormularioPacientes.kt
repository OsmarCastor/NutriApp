package castor.no.c.programar.nutriapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_formulario_pacientes.txtIdPaciente
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class FormularioPacientes : AppCompatActivity() {
    lateinit var txtId:TextView
    lateinit var txtNombre:TextView
    lateinit var txtEdad:TextView
    lateinit var txtSexo:TextView
    lateinit var txtTelefono:TextView
    lateinit var txtFecha:TextView
    lateinit var txtPeso:TextView
    lateinit var txtEstatura:TextView
    lateinit var txtPorcentaje:TextView
    lateinit var txtImc:TextView
    lateinit var txtPi:TextView
    lateinit var txtGet:TextView
    lateinit var txtGeb:TextView
    lateinit var db :NutriApp
    var id = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_pacientes)
        db = this.application as NutriApp
        supportActionBar?.hide()
        txtId = findViewById(R.id.txtIdPaciente)
        txtNombre = findViewById(R.id.txtNomPaciente)
        txtEdad = findViewById(R.id.txtEdadPaciente)
        txtSexo = findViewById(R.id.txtSexo)
        txtTelefono = findViewById(R.id.txtTelPaciente)
        txtFecha = findViewById(R.id.txtFechaPaciente)
        txtPeso = findViewById(R.id.txtPesoPaciente)
        txtEstatura = findViewById(R.id.txtEsPaciente)
        txtPorcentaje = findViewById(R.id.txtPorPaciente)
        txtImc = findViewById(R.id.txtImcPaciente)
        txtPi = findViewById(R.id.txtPiPaciente)
        txtGet = findViewById(R.id.txtGetPAciente)
        txtGeb = findViewById(R.id.txtGebPaciente)
        id = intent.getIntExtra("idpaciente", 0)
        lifecycleScope.launch{
            val paciente = db.room.pacienteDao().getById(id)
            txtId.text = id.toString()
            txtNombre.text = paciente.nombre
            txtEdad.text = paciente.edad
            if (paciente.sexo == "Masculino"){
                txtSexo.text = "M"
            }else{
                txtSexo.text = "F"
            }
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
    }
    fun actualizarPaciente(v: View) {
        val intent = Intent(this, ActualizarDatos::class.java)
        intent.putExtra("idpacientes", txtIdPaciente.text.toString().toInt())
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        lifecycleScope.launch{
            val paciente = db.room.pacienteDao().getById(id)
            txtId.text = id.toString()
            txtNombre.text = paciente.nombre
            txtEdad.text = paciente.edad
            if (paciente.sexo == "Masculino"){
                txtSexo.text = "M"
            }else{
                txtSexo.text = "F"
            }
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
    }
    fun guardarBD(v: View){
        val id = txtId.text.toString().toInt()
        val nombre = txtNombre.text.toString()
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
    fun hacerIMC(v: View){
        //Aqui hacer operacion de peso*(altura)^2
        val peso = txtPeso.text.toString().toDouble()
        val estatura = txtEstatura.text.toString().toDouble()
        val exponente = 2
        val potencia = Math.pow(estatura, exponente.toDouble())
        var res = peso/(potencia)
        val imc = res*10000
        val redondea = (imc * 100.0).roundToInt() / 100.0
        txtImc.text = redondea.toString()
    }
    fun hacerPI(v: View){
        //Aqui hacer PI
        val estatura = txtEstatura.text.toString().toDouble()
        val pi = (50+(.75+(estatura-150)))
        txtPi.text = pi.toString()
    }
    fun hacerGET(v: View){
        //Aqui se calcula el Gasto Energetico Total
        if (txtGeb.text.toString().toDouble() == 0.0){
            Toast.makeText(this, "Calcula el GEB primero", Toast.LENGTH_LONG).show()
        }else{
            val geb = txtGeb.text.toString().toDouble()
            val porcentaje = txtPorcentaje.text.toString().toInt()
            var geaf = (porcentaje*geb)/100
            var eta = geb*.1
            val get = geb+eta+geaf
            txtGet.text = get.toString()
        }
    }
    fun hacerGEB(v: View){
        //Aqui se calcula el Gasto Energetico Basal
        val peso = txtPeso.text.toString().toDouble()
        val estatura = txtEstatura.text.toString().toDouble()
        val sexo = txtSexo.text.toString()
        val edad = txtEdad.text.toString().toInt()
        if (sexo == "Masculino"){
            val geb = 66.473+(13.7516*peso)+(5.0033*estatura)-(6.755*edad)
            val redondea = (geb * 100.0).roundToInt() / 100.0
            txtGeb.text = redondea.toString()
        }else{
            val geb = 655.0955+(9.5634*peso)+(1.8495*estatura)-(4.6756*edad)
            val redondea = (geb * 100.0).roundToInt() / 100.0
            txtGeb.text = redondea.toString()
        }
    }
    fun borrarPaciente(V: View){
        val id = txtId.text.toString().toInt()
        val nombre = txtNombre.text.toString()
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
            db.room.pacienteDao().delete(paciente)
        }
        Toast.makeText(this, "Paciente eliminado", Toast.LENGTH_LONG).show()
        finish()
    }
}