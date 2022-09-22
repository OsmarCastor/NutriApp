package castor.no.c.programar.nutriapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
    }

    override fun onStart() {
        super.onStart()
        Handler().postDelayed({
            val intent = Intent(this, mostrarPaciente::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}