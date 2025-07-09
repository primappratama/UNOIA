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
    private val showSeller: Boolean // true = tampilkan seller, false = hanya produk
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Layout produk
        val cardProduct: View = view.findViewById(R.id.cardProduct)
        val imageProduct: ImageView = view.findViewById(R.id.imageProduct)
        val textName: TextView = view.findViewById(R.id.textName)
        val textPrice: TextView = view.findViewById(R.id.textPrice)
        val textSize: TextView = view.findViewById(R.id.textSize)
        val btnFav: ImageButton = view.findViewById(R.id.btnFav)

        // Layout seller
        val layoutSeller: View = view.findViewById(R.id.layoutSeller)
        val item1: ImageView = view.findViewById(R.id.item1)
        val item2: ImageView = view.findViewById(R.id.item2)
        val item3: ImageView = view.findViewById(R.id.item3)
        val profile: ImageView = view.findViewById(R.id.ivProfile)
        val sellerName: TextView = view.findViewById(R.id.tvSellerName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        when (val item = items[position]) {
            is ProductItem.Product -> {
                holder.cardProduct.visibility = View.VISIBLE
                holder.layoutSeller.visibility = View.GONE

                holder.imageProduct.setImageResource(item.imageRes)
                holder.textName.text = item.name
                holder.textPrice.text = item.price
                holder.textSize.text = item.size
            }

            is ProductItem.Seller -> {
                if (showSeller) {
                    holder.cardProduct.visibility = View.GONE
                    holder.layoutSeller.visibility = View.VISIBLE

                    holder.item1.setImageResource(item.item1)
                    holder.item2.setImageResource(item.item2)
                    holder.item3.setImageResource(item.item3)
                    holder.profile.setImageResource(item.profileImage)
                    holder.sellerName.text = item.name
                } else {
                    // Jangan tampilkan seller jika showSeller = false
                    holder.cardProduct.visibility = View.GONE
                    holder.layoutSeller.visibility = View.GONE
                }
            }
        }
    }

    override fun getItemCount(): Int = items.size
}
