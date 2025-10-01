package gutierrez.ruben.popcornfactory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var adapter: PeliculaAdapter? = null
    var peliculas = ArrayList<Pelicula>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
 val peliculas = listOf(
     Pelicula("Bones",R.drawable.bones,1,"a"),
             Pelicula("Friends",R.drawable.friends,1,"a"),
     Pelicula("Smallville",R.drawable.smallville,1,"a")
 )


        val recycler_peliculas: RecyclerView = findViewById<RecyclerView>(R.id.lista_view)
        recycler_peliculas.layoutManager = LinearLayoutManager(this)
        recycler_peliculas.adapter = AdaptadorPeliculas(peliculas)
    }



}

class PeliculaAdapter: BaseAdapter {
    var peliculas = ArrayList<Pelicula>()
    var context: Context? = null

    constructor(context: Context, peliculas: ArrayList<Pelicula>) {
        this.context = context
        this.peliculas = peliculas
    }

    override fun getCount(): Int {
        return peliculas.size
    }

    override fun getItem(position: Int): Any {
        return peliculas[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var pelicula = peliculas[position]
        val inflator = LayoutInflater.from(parent?.context)
        val vista = inflator.inflate(R.layout.pelicula, parent, false)

        vista.findViewById<ImageView>(R.id.iv_pelicula).setImageResource(pelicula.image)
        vista.findViewById<TextView>(R.id.tv_nombre_pelicula).text = pelicula.titulo

        vista.findViewById<ImageView>(R.id.iv_pelicula).setOnClickListener {
            var intent = Intent(context, DetallePelicula::class.java)
            intent.putExtra("titulo", pelicula.titulo)
            intent.putExtra("image", pelicula.image)
            intent.putExtra("header", pelicula.header)
            intent.putExtra("sinopsis", pelicula.sinopsis)
            parent?.context?.startActivity(intent)
        }

        return vista
    }
}