package muchamadalfaidzin.informatika.tilas.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.R

class ProductAdapter(private val items: List<ProductItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_PRODUCT = 0
        private const val TYPE_SELLER = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ProductItem.Product -> TYPE_PRODUCT
            is ProductItem.Seller -> TYPE_SELLER
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_PRODUCT -> {
                val view = inflater.inflate(R.layout.item_product, parent, false)
                ProductViewHolder(view)
            }
            TYPE_SELLER -> {
                val view = inflater.inflate(R.layout.item_seller, parent, false)
                SellerViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is ProductItem.Product -> (holder as ProductViewHolder).bind(item)
            is ProductItem.Seller -> (holder as SellerViewHolder).bind(item)
        }
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.imageProduct)
        private val name: TextView = itemView.findViewById(R.id.textName)
        private val price: TextView = itemView.findViewById(R.id.textPrice)
        private val size: TextView = itemView.findViewById(R.id.textSize)
        private val favButton: ImageButton = itemView.findViewById(R.id.btnFav)

        fun bind(item: ProductItem.Product) {
            image.setImageResource(item.imageRes)
            name.text = item.name
            price.text = item.price
            size.text = item.size
            // Opsional: tambahkan listener ke tombol favorit
            // favButton.setOnClickListener { ... }
        }
    }

    class SellerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val item1: ImageView = itemView.findViewById(R.id.item1)
        private val item2: ImageView = itemView.findViewById(R.id.item2)
        private val item3: ImageView = itemView.findViewById(R.id.item3)
        private val profile: ImageView = itemView.findViewById(R.id.ivProfile)
        private val name: TextView = itemView.findViewById(R.id.tvSellerName)

        fun bind(item: ProductItem.Seller) {
            item1.setImageResource(item.item1)
            item2.setImageResource(item.item2)
            item3.setImageResource(item.item3)
            profile.setImageResource(item.profileImage)
            name.text = item.name
        }
    }
}
