package castor.no.c.programar.nutriapp

import android.app.Application
import androidx.room.Room

class PacientesApp : Application() {
    val room = Room.databaseBuilder(this, AppDatabase::class.java, "paciente").build()
}