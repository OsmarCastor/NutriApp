package castor.no.c.programar.nutriapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log

class mostrarPaciente : AppCompatActivity() {
    lateinit var recycler: RecyclerView
    //lateinit var db :PacientesApp
    companion object{
        //val dao = PacientesApp()
        //val lista= dao.room.pacienteDao().getAll()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_paciente)
        supportActionBar?.hide()
        recycler = findViewById(R.id.rv_persona)
        val db = this.application as PacientesApp
        Log.e("Algo","asasas")
    }
    fun abrirAregar(v: View){
        val intent = Intent(this, agregarPaciente::class.java)
        startActivity(intent)
    }
    override fun onPostResume() {
        super.onPostResume()
        actualizarRecycler()
    }
    fun actualizarRecycler(){
        //val lista = db.room.pacienteDao().getAll()
        //val adaptador = Adaptador(this, lista)
        //recycler.adapter = adaptador
    }
}