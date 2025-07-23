package muchamadalfaidzin.informatika.tilas.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.R

class ItemAdapter(private val itemList: List<Item>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.tvItemName)
        val desc = view.findViewById<TextView>(R.id.tvItemDesc)
        val stock = view.findViewById<TextView>(R.id.tvItemStock)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.name.text = item.name
        holder.desc.text = item.description
        holder.stock.text = "Stock: ${item.stock}"
    }
}
