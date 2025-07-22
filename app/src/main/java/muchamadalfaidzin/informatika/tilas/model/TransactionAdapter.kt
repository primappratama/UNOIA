package muchamadalfaidzin.informatika.tilas.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.R

class TransactionAdapter(private val txList: List<Transaction>) :
    RecyclerView.Adapter<TransactionAdapter.TxViewHolder>() {

    inner class TxViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val invoice = view.findViewById<TextView>(R.id.tvInvoice)
        val date = view.findViewById<TextView>(R.id.tvDate)
        val amount = view.findViewById<TextView>(R.id.tvAmount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TxViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_transaction, parent, false)
        return TxViewHolder(view)
    }

    override fun getItemCount() = txList.size

    override fun onBindViewHolder(holder: TxViewHolder, position: Int) {
        val tx = txList[position]
        holder.invoice.text = tx.invoice
        holder.date.text = tx.date
        holder.amount.text = "Rp ${tx.totalAmount}"
    }
}
