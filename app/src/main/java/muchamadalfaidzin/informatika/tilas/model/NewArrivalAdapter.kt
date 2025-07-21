package muchamadalfaidzin.informatika.tilas.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.R

class NewArrivalAdapter(private val imageList: List<Int>) :
    RecyclerView.Adapter<NewArrivalAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgNewArrival: ImageView = itemView.findViewById(R.id.imgNewArrival)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_new_arrival, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgNewArrival.setImageResource(imageList[position])
    }

    override fun getItemCount(): Int = imageList.size
}