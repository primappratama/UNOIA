package muchamadalfaidzin.informatika.tilas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.model.Transaction
import muchamadalfaidzin.informatika.tilas.model.TransactionAdapter

class ManageTransactionsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TransactionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_transactions)

        recyclerView = findViewById(R.id.rvTransactions)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = TransactionAdapter(getDummyTransactions())
        recyclerView.adapter = adapter
    }

    private fun getDummyTransactions(): List<Transaction> {
        return listOf(
            Transaction("INV001", "2025-07-21", 25000),
            Transaction("INV002", "2025-07-22", 45000),
            Transaction("INV003", "2025-07-23", 15000)
        )
    }
}
