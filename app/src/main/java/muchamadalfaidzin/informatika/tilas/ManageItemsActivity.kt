package muchamadalfaidzin.informatika.tilas

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.model.Item
import muchamadalfaidzin.informatika.tilas.model.ItemAdapter

class ManageItemsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter // kamu harus buat class ini

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_items)

        recyclerView = findViewById(R.id.rvItems)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = ItemAdapter(getDummyItems())
        recyclerView.adapter = adapter

        val btnAdd = findViewById<Button>(R.id.btnAddItem)
        btnAdd.setOnClickListener {
            Toast.makeText(this, "Add Item Clicked", Toast.LENGTH_SHORT).show()
            // Arahkan ke form tambah item jika ingin
        }
    }

    private fun getDummyItems(): List<Item> {
        return listOf(
            Item("Masker N95", "Alat kesehatan", 10),
            Item("Hand Sanitizer", "Cairan antiseptik", 25)
        )
    }
}
