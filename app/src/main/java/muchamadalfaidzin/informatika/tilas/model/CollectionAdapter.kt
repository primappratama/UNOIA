package muchamadalfaidzin.informatika.tilas.model.CollectionAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.R
import muchamadalfaidzin.informatika.tilas.model.CollectionItem

class CollectionAdapter(private val items: List<CollectionItem>) :
    RecyclerView.Adapter<CollectionAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivImage: ImageView = itemView.findViewById(R.id.ivCollectionImage)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvHarga: TextView = itemView.findViewById(R.id.tvHarga)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_rvshirt_blouses, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.ivImage.setImageResource(item.imageResId)
        holder.tvTitle.text = item.title
        holder.tvHarga.text = item.price
    }

    override fun getItemCount(): Int = items.size
}
