package muchamadalfaidzin.informatika.tilas

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.model.ShoppingBagItem


class ShoppingBagAdapter(
    private val items: List<ShoppingBagItem>,
    private val onPlusClicked: (position: Int) -> Unit,
    private val onMinusClicked: (position: Int) -> Unit,
    private val onDeleteClicked: (position: Int) -> Unit,
    private val onFavoriteClicked: (position: Int) -> Unit
) : RecyclerView.Adapter<ShoppingBagAdapter.ShoppingBagViewHolder>() {

    inner class ShoppingBagViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageProduct: ImageView = itemView.findViewById(R.id.imageProduct)
        val tvProductName: TextView = itemView.findViewById(R.id.tvProductName)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val tvQty: TextView = itemView.findViewById(R.id.tvQty)
        val btnPlus: ImageView = itemView.findViewById(R.id.btnPlus)
        val btnMinus: ImageView = itemView.findViewById(R.id.btnMinus)
        val btnDelete: ImageButton = itemView.findViewById(R.id.btnDelete)
        val btnFavorite: ImageButton = itemView.findViewById(R.id.btnFavorite)
        val llDetails: LinearLayout = itemView.findViewById(R.id.llDetails)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingBagViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_rvshoppingbag, parent, false)
        return ShoppingBagViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingBagViewHolder, position: Int) {
        val item = items[position]
        holder.imageProduct.setImageResource(item.imageRes)
        holder.tvProductName.text = item.productName
        holder.tvPrice.text = item.price
        holder.tvQty.text = item.quantity.toString()

        // Update detail section
        holder.llDetails.removeAllViews()
        holder.llDetails.addView(createDetailText(holder.itemView.context, "Color     ${item.color}"))
        holder.llDetails.addView(createDetailText(holder.itemView.context, "Size       ${item.size}"))
        holder.llDetails.addView(createDetailText(holder.itemView.context, "Total     ${item.total}", bold = true))

        // Actions
        holder.btnPlus.setOnClickListener { onPlusClicked(position) }
        holder.btnMinus.setOnClickListener { onMinusClicked(position) }
        holder.btnDelete.setOnClickListener { onDeleteClicked(position) }
        holder.btnFavorite.setOnClickListener { onFavoriteClicked(position) }
    }

    override fun getItemCount(): Int = items.size

    private fun createDetailText(context: Context, text: String, bold: Boolean = false): TextView {
        return TextView(context).apply {
            this.text = text
            setTextAppearance(android.R.style.TextAppearance_Material_Body1)
            if (bold) setTypeface(typeface, Typeface.BOLD)
        }
    }
}
