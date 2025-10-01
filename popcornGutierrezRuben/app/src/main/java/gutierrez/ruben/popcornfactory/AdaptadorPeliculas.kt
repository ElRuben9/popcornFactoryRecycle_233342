package gutierrez.ruben.popcornfactory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AdaptadorPeliculas(val peliculas_list: List <Pelicula>): RecyclerView.Adapter<AdaptadorPeliculas.PeliculasViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PeliculasViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.lista_pelicula, parent,false)
        return PeliculasViewHolder(itemView)
    }

    override fun onBindViewHolder(

        holder: PeliculasViewHolder,
        position: Int
    ) {
     val pelicula: Pelicula = peliculas_list[position]
        holder.imagen_pelicula.setImageResource(pelicula.image)
        holder.titulo.text = pelicula.titulo
        holder.desc.text = pelicula.sinopsis
    }

    override fun getItemCount(): Int {
        return peliculas_list.size
    }

    class PeliculasViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var imagen_pelicula: ImageView = itemView.findViewById(R.id.imagen_pelicula)
        var titulo: TextView = itemView.findViewById(R.id.titulo_pelicula)
        var desc: TextView = itemView.findViewById(R.id.desc_pelicula)
    }

}