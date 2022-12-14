package castor.no.c.programar.nutriapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adaptador(context: Context, private var datos:List<Pacientes>, private  var paciente: cellClickListenerClient): RecyclerView.Adapter<Adaptador.ViewHolderPersona>() {
    class ViewHolderPersona(item: View):RecyclerView.ViewHolder(item){
        var txtNombre: TextView = item.findViewById(R.id.txtNom)
        var txtEdad: TextView = item.findViewById(R.id.txtAge)
        var txtId: TextView = item.findViewById(R.id.txtId)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPersona {
        val layoutItem = LayoutInflater.from(parent.context).inflate(R.layout.recycler, parent, false)
        return ViewHolderPersona(layoutItem)
    }
    override fun onBindViewHolder(holder: ViewHolderPersona, position: Int) {
        val persona = datos[position]
        holder.txtNombre.text = persona.nombre
        holder.txtEdad.text = persona.edad
        holder.txtId.text = persona.idPaciente.toString()
        holder.itemView.setOnClickListener{
            paciente.clickExpediente(persona)
            Log.e("prueba","Di clic")
        }
    }
    override fun getItemCount(): Int = datos.size

}