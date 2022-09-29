package castor.no.c.programar.nutriapp

import androidx.room.*

@Dao
interface Sentencias {
    @Query("SELECT * FROM Pacientes")
    suspend fun getAll(): List<Pacientes>

    @Update
    suspend fun update(persona: Pacientes)

    @Insert
    suspend fun insert(persona: Pacientes)


}