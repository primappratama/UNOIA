package muchamadalfaidzin.informatika.tilas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.model.ProductAdapter
import muchamadalfaidzin.informatika.tilas.model.ProductItem

class HomepageMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_homepage_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProduct)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val productList = listOf<ProductItem>(
            ProductItem.Product(R.drawable.vansblack, "Vans Black Hi", "Rp 1.000.000", "41"),
            ProductItem.Product(R.drawable.vans_backpack, "Vans Backpack", "Rp 4.500.000", "41"),

        )

        val adapter = ProductAdapter(productList)
        recyclerView.adapter = adapter

    }
}