package castor.no.c.programar.nutriapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MostrarPaciente : AppCompatActivity(), cellClickListenerClient {
    lateinit var recycler: RecyclerView
    lateinit var db :NutriApp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_paciente)
        supportActionBar?.hide()
        recycler = findViewById(R.id.rv_persona)
        db = this.application as NutriApp
    }
    fun abrirAregar(v: View){
        val intent = Intent(this, AgregarPaciente::class.java)
        startActivity(intent)
    }
    override fun onPostResume() {
        super.onPostResume()
        actualizarRecycler()
    }
    fun actualizarRecycler(){
        lifecycleScope.launch{
            val lista= db.room.pacienteDao().getAll()
            actualizarRecyclerDespues(lista)
        }
    }
    fun actualizarRecyclerDespues(list: List<Pacientes>){
        val adaptador = Adaptador(this, list, this)
        recycler.adapter = adaptador
    }
    override fun clickExpediente(paciente: Pacientes) {
        val intent = Intent(this, FormularioPacientes::class.java)
        intent.putExtra("idpaciente",paciente.idPaciente)
        startActivity(intent)
    }
}