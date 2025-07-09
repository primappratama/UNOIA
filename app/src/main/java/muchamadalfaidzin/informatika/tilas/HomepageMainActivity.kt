package muchamadalfaidzin.informatika.tilas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.adapter.ProductAdapter
import muchamadalfaidzin.informatika.tilas.model.ProductItem

class HomepageMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rvProducts)

        val productList = listOf(
            ProductItem.Product(
                imageRes = R.drawable.vansblack,
                name = "Vans Black Hi",
                price = "Rp 1.000.000",
                size = "41"
            ),
            ProductItem.Product(
                imageRes = R.drawable.vans_backpack,
                name = "Vans OFF The Walls",
                price = "Rp 4.500.000",
                size = "41"
            ),
            ProductItem.Product(
                imageRes = R.drawable.sepatu,
                name = "Air Court 1 Retro",
                price = "Rp 3.700.000",
                size = "42"
            ),
            ProductItem.Product(
                imageRes = R.drawable.jacket,
                name = "Stussy Jacket",
                price = "Rp 1.990.000",
                size = "XL"
            ),
            ProductItem.Product(
                imageRes = R.drawable.kaos_66,
                name = "Kaos Jersey 66",
                price = "Rp 1.200.000",
                size = "L"
            )
        )

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = ProductAdapter(productList, showSeller = false) // <== INI YANG BELUM ADA
    }
}
