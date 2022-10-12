package castor.no.c.programar.nutriapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity
data class Pacientes(
    @PrimaryKey(autoGenerate = true) val idPaciente: Int,
    @ColumnInfo(name = "Nombre") val nombre: String?,
    @ColumnInfo(name = "Edad") val edad: String?,
    @ColumnInfo(name = "Telefono") val telefono: String?,
    @ColumnInfo(name = "Fecha_Nacimiento") val fecha: String?,
    @ColumnInfo(name = "Peso") val peso: String?,
    @ColumnInfo(name = "Estatura") val talla: String?,
    @ColumnInfo(name = "Porcentaje_Actividad_Física") val porcentaje: Int?,
    @ColumnInfo(name = "IMC") val imc: Int?,
    @ColumnInfo(name = "Peso_Ideal") val pi: Int?,
    @ColumnInfo(name = "GET") val get: Int?

)
