package castor.no.c.programar.nutriapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class formularioPacientes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_pacientes)
        supportActionBar?.hide()
    }
}