package castor.no.c.programar.nutriapp

import java.util.Date

data class paciente(
    val nombre:String,
    val edad:Int,
    val telefono:String,
    val fecha:Date,
    val peso:Float,
    val estatura:Float
)
