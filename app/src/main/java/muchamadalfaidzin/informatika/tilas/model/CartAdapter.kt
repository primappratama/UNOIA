package muchamadalfaidzin.informatika.tilas.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.R

class CartAdapter(private val items: List<CartItem>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgProduct: ImageView = itemView.findViewById(R.id.imgProduct)
        val txtProductName: TextView = itemView.findViewById(R.id.txtProductName)
        val txtOriginalPrice: TextView = itemView.findViewById(R.id.txtOriginalPrice)
        val txtColor: TextView = itemView.findViewById(R.id.txtColor)
        val txtSize: TextView = itemView.findViewById(R.id.txtSize)
        val txtTotal: TextView = itemView.findViewById(R.id.txtTotal)
        val txtQuantity: TextView = itemView.findViewById(R.id.txtQuantity)
        val btnPlus: TextView = itemView.findViewById(R.id.btnPlus)
        val btnMinus: TextView = itemView.findViewById(R.id.btnMinus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = items[position]
        holder.imgProduct.setImageResource(item.imageResId)
        holder.txtProductName.text = item.name
        holder.txtOriginalPrice.text = item.price
        holder.txtColor.text = "Color: ${item.color}"
        holder.txtSize.text = "Size: ${item.size}"
        holder.txtQuantity.text = item.quantity.toString()
        holder.txtTotal.text = "Total: ${item.price}"

        holder.btnPlus.setOnClickListener {
            item.quantity++
            notifyItemChanged(position)
        }

        holder.btnMinus.setOnClickListener {
            if (item.quantity > 1) {
                item.quantity--
                notifyItemChanged(position)
            }
        }
    }

    override fun getItemCount() = items.size
}
