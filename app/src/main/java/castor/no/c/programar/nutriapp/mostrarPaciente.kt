package castor.no.c.programar.nutriapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class mostrarPaciente : AppCompatActivity() {
    lateinit var recycler: RecyclerView
    companion object{
        //val pacientes = ArrayList<paciente>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_paciente)
        supportActionBar?.hide()
        recycler = findViewById(R.id.rv_persona)
    }
    fun abrirAregar(v: View){
        val intent = Intent(this, agregarPaciente::class.java)
        startActivity(intent)
    }
    fun abrirForm(v: View){
        val intent = Intent(this, formularioPacientes::class.java)
        startActivity(intent)
    }
    override fun onPostResume() {
        super.onPostResume()
        actualizarRecycler()
    }
    fun actualizarRecycler(){
        //val adaptador = Adaptador(this, pacientes)
        //recycler.adapter = adaptador
    }
}