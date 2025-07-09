package muchamadalfaidzin.informatika.tilas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.R
import muchamadalfaidzin.informatika.tilas.model.ProductItem

class ProductAdapter(
    private val items: List<ProductItem>,
    private val showSeller: Boolean
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
        return when (viewType) {
            TYPE_PRODUCT -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_product, parent, false)
                ProductViewHolder(view)
            }
            TYPE_SELLER -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_seller, parent, false)
                SellerViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is ProductItem.Product -> (holder as ProductViewHolder).bind(item)
            is ProductItem.Seller -> {
                if (showSeller) {
                    (holder as SellerViewHolder).bind(item)
                }
            }
        }
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageProduct: ImageView = itemView.findViewById(R.id.imageProduct)
        private val textName: TextView = itemView.findViewById(R.id.textName)
        private val textPrice: TextView = itemView.findViewById(R.id.textPrice)
        private val textSize: TextView = itemView.findViewById(R.id.textSize)
        private val btnFav: ImageButton = itemView.findViewById(R.id.btnFav)

        fun bind(product: ProductItem.Product) {
            imageProduct.setImageResource(product.imageRes)
            textName.text = product.name
            textPrice.text = product.price
            textSize.text = "Ukuran: ${product.size}"
        }
    }

    inner class SellerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val item1: ImageView = itemView.findViewById(R.id.item1)
        private val item2: ImageView = itemView.findViewById(R.id.item2)
        private val item3: ImageView = itemView.findViewById(R.id.item3)
        private val ivProfile: ImageView = itemView.findViewById(R.id.ivProfile)
        private val tvSellerName: TextView = itemView.findViewById(R.id.tvSellerName)

        fun bind(seller: ProductItem.Seller) {
            item1.setImageResource(seller.item1)
            item2.setImageResource(seller.item2)
            item3.setImageResource(seller.item3)
            ivProfile.setImageResource(seller.profileImage)
            tvSellerName.text = seller.name
        }
    }
}
