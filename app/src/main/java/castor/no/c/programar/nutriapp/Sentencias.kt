package castor.no.c.programar.nutriapp

import androidx.room.*

@Dao
interface Sentencias {
    @Query("SELECT * FROM Pacientes")
    fun getAll(): List<Pacientes>

    @Update
    fun update(persona: Pacientes)

    @Insert
    fun insert(paciente: List<Pacientes>)


}