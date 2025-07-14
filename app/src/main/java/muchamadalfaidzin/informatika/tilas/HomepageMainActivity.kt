package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import muchamadalfaidzin.informatika.tilas.adapter.ProductAdapter
import muchamadalfaidzin.informatika.tilas.adapter.ProductHorizontalAdapter
import muchamadalfaidzin.informatika.tilas.adapter.SellerAdapter
import muchamadalfaidzin.informatika.tilas.model.ProductItem
import muchamadalfaidzin.informatika.tilas.model.SellerItem

class HomepageMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage_main)

        val rvProductsHorizontal = findViewById<RecyclerView>(R.id.rvProductsHorizontal)

        val recommendedList = listOf(
            ProductItem.Product(R.drawable.stranger, "The Stranger", "Rp 40.000", ""),
            ProductItem.Product(R.drawable.kafka, "Metamorphosis", "Rp 50.000", ""),
            ProductItem.Product(R.drawable.guitar, "Yamaha FG-840", "Rp 1.600.000", ""),
            ProductItem.Product(R.drawable.fyodor, "White Night", "Rp 60.000", ""),
            ProductItem.Product(R.drawable.settingsunsdazai, "The Setting Sun", "Rp 50.000", "")
        )

        rvProductsHorizontal.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvProductsHorizontal.adapter =
            ProductHorizontalAdapter(recommendedList)

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
        recyclerView.adapter = ProductAdapter(productList, showSeller = false)

        // --- Tambahan untuk Seller RecyclerView ---
        val sellerList = listOf(
            SellerItem(
                item1Res = R.drawable.item1,
                item2Res = R.drawable.item2,
                item3Res = R.drawable.item3,
                profileRes = R.drawable.profile,
                sellerName = "Jzevanya"
            ),
            SellerItem(
                item1Res = R.drawable.item4,
                item2Res = R.drawable.item7,
                item3Res = R.drawable.item6,
                profileRes = R.drawable.ellie,
                sellerName = "Eienorion"
            ),
            SellerItem(
                item1Res = R.drawable.item8,
                item2Res = R.drawable.item9,
                item3Res = R.drawable.item10,
                profileRes = R.drawable.hanni,
                sellerName = "HanniPham"
            )
        )

        val rvSellers = findViewById<RecyclerView>(R.id.rvSellers)
        rvSellers.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvSellers.adapter = SellerAdapter(sellerList)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Sudah di homepage, tidak perlu pindah
                    true
                }

                R.id.nav_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }
    }
    }

