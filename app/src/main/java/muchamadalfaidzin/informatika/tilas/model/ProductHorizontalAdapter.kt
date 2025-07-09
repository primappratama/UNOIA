package muchamadalfaidzin.informatika.tilas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.R
import muchamadalfaidzin.informatika.tilas.model.ProductItem

class ProductHorizontalAdapter(
    private val items: List<ProductItem.Product>
) : RecyclerView.Adapter<ProductHorizontalAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val img: ImageView = view.findViewById(R.id.barang1)
        private val title: TextView = view.findViewById(R.id.tvJudul)
        private val price: TextView = view.findViewById(R.id.tvHarga)

        fun bind(item: ProductItem.Product) {
            img.setImageResource(item.imageRes)
            title.text = item.name
            price.text = item.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product_horizontal, parent, false) // pakai file yang kamu upload
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
