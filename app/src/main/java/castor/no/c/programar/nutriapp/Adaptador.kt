package castor.no.c.programar.nutriapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adaptador(context: Context, private var datos:List<Pacientes>): RecyclerView.Adapter<Adaptador.ViewHolderPersona>() {
    class ViewHolderPersona(item: View):RecyclerView.ViewHolder(item){
        var txtNombre: TextView = item.findViewById(R.id.txtNom)
        var txtEdad: TextView = item.findViewById(R.id.txtAge)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPersona {
        val layoutItem = LayoutInflater.from(parent.context).inflate(R.layout.recycler, parent, false)
        return ViewHolderPersona(layoutItem)
    }
    override fun onBindViewHolder(holder: ViewHolderPersona, position: Int) {
        val persona = datos[position]
        holder.txtNombre.text = persona.nombre
        holder.txtEdad.text = persona.edad
    }
    override fun getItemCount(): Int = datos.size
}