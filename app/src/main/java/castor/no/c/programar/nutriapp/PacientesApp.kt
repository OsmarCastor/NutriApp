package castor.no.c.programar.nutriapp

import android.app.Application
import androidx.room.Room

class PacientesApp : Application() {
    lateinit var room: AppDatabase

    override fun onCreate() {
        super.onCreate()
        room =  Room.databaseBuilder(this, AppDatabase::class.java, "paciente").build()
    }
}