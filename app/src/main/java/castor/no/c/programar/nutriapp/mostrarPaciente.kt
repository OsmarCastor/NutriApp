package castor.no.c.programar.nutriapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class mostrarPaciente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_paciente)
        supportActionBar?.hide()
    }
    fun abrirAregar(v: View){
        val intent = Intent(this, agregarPaciente::class.java)
        startActivity(intent)
    }
    fun abrirForm(v: View){
        val intent = Intent(this, formularioPaciente::class.java)
        startActivity(intent)
    }
}