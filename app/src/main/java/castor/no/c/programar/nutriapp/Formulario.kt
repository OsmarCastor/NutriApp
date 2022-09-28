package castor.no.c.programar.nutriapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Formulario(
    @PrimaryKey val idFormulario: Int,
    @ColumnInfo(name = "IMC") val imc: Int?,
    @ColumnInfo(name = "Peso_Ideal") val pesoI: Int?,
    @ColumnInfo(name = "GET") val GET: Int?,
    @ColumnInfo(name = "Paciente") val idPaciente: Int?
)
