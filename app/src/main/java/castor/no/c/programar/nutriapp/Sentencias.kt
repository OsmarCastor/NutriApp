package castor.no.c.programar.nutriapp

import androidx.room.*

@Dao
interface Sentencias {
    @Query("SELECT * FROM Pacientes")
    suspend fun getAll(): List<Pacientes>

    @Query("SELECT * FROM Pacientes WHERE idPaciente IN (:idenPaciente)")
    suspend fun getById(idenPaciente: Int): List<Pacientes>

    @Update
    suspend fun update(persona: Pacientes)

    @Insert
    suspend fun insert(persona: Pacientes)


}