package castor.no.c.programar.nutriapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class baseDatitos(context: Context, private var datos:List<paciente>): RecyclerView.Adapter<baseDatitos.ViewHolderPaciente>() {
    class ViewHolderPaciente(item: View):RecyclerView.ViewHolder(item){
        var txtNombre: TextView = item.findViewById(R.id.txtNom)
        var txtEdad: TextView = item.findViewById(R.id.txtAge)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPaciente {
        val layoutItem = LayoutInflater.from(parent.context).inflate(R.layout.recycler, parent, false)
        return ViewHolderPaciente(layoutItem)
    }

    override fun onBindViewHolder(holder: ViewHolderPaciente, position: Int) {
        val paciente = datos[position]
        holder.txtNombre.text = paciente.nombre
        holder.txtEdad.text = paciente.edad.toString()
    }

    override fun getItemCount(): Int = datos.size
}