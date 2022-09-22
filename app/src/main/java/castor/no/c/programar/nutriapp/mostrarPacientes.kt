package castor.no.c.programar.nutriapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class mostrarPacientes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(3000)
        setTheme(R.style.Theme_NutriApp)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_pacientes)
    }
    fun abrirAregar(v: View){
        val intent = Intent(this, agregarPaciente::class.java)
        startActivity(intent)
    }
}