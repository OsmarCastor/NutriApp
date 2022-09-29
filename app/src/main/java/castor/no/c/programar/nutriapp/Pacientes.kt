package castor.no.c.programar.nutriapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pacientes(
    @PrimaryKey(autoGenerate = true) val idPaciente: Int,
    @ColumnInfo(name = "Nombre") val nombre: String?,
    @ColumnInfo(name = "Edad") val edad: Int?,
    @ColumnInfo(name = "Telefono") val telefono: String?,
    @ColumnInfo(name = "Fecha_Nacimiento") val fecha: Int?,
    @ColumnInfo(name = "Peso") val peso: Int?,
    @ColumnInfo(name = "Estatura") val talla: Int?,
    @ColumnInfo(name = "Porcentaje_Actividad_Física") val porcentaje: String?
)
