package castor.no.c.programar.nutriapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Pacientes::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pacienteDao(): Sentencias
}