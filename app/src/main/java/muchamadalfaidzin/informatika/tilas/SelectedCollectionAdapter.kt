package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.model.CollectionItem

class SelectedCollectionAdapter(private val collectionList: List<CollectionItem>) :
    RecyclerView.Adapter<SelectedCollectionAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivImage: ImageView = itemView.findViewById(R.id.ivCollectionImage)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvExplore: TextView = itemView.findViewById(R.id.tvExplore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_selected_collection, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = collectionList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = collectionList[position]
        holder.ivImage.setImageResource(item.imageResId)
        holder.tvTitle.text = item.title
        holder.tvExplore.text = item.subtitle

        // Klik item
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context

            when (item.title) {
                "SHIRT & BLOUSES" -> {
                    val intent = Intent(context, ShirtBlousesActivity::class.java)
                    intent.putExtra("title", item.title)
                    intent.putExtra("imageResId", item.imageResId)
                    context.startActivity(intent)
                }
                "JEANS" -> {
                    val intent = Intent(context, JeansActivity::class.java)
                    intent.putExtra("title", item.title)
                    intent.putExtra("imageResId", item.imageResId)
                    context.startActivity(intent)
                }
                "TROUSERS" -> {
                    val intent = Intent(context, TrousersActivity::class.java)
                    intent.putExtra("title", item.title)
                    intent.putExtra("imageResId", item.imageResId)
                    context.startActivity(intent)
                }
                "BEST PRICE" -> {
                    val intent = Intent(context, BestPriceActivity::class.java)
                    intent.putExtra("title", item.title)
                    intent.putExtra("imageResId", item.imageResId)
                    context.startActivity(intent)
                }
                // Tambahkan koleksi lainnya di sini jika perlu
            }
        }

    }
}
