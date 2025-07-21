package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import muchamadalfaidzin.informatika.tilas.adapter.SellerAdapter
import muchamadalfaidzin.informatika.tilas.model.NewArrivalAdapter
import muchamadalfaidzin.informatika.tilas.model.ProductItem
import muchamadalfaidzin.informatika.tilas.model.SellerItem

class HomepageGuestActivity : AppCompatActivity() {

    private lateinit var recyclerNewArrival: RecyclerView
    private lateinit var adapter: NewArrivalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage_guest)

        recyclerNewArrival = findViewById(R.id.recyclerNewArrival)

        val images = listOf(
            R.drawable.new1,
            R.drawable.new2,
            R.drawable.new3,
            R.drawable.new4,
            R.drawable.new5,
            R.drawable.new6,
            R.drawable.new7,
            R.drawable.new8,
            R.drawable.new9
        )

<<<<<<< HEAD
        adapter = NewArrivalAdapter(images)
        recyclerNewArrival.layoutManager = GridLayoutManager(this, 3)
        recyclerNewArrival.adapter = adapter
=======
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
            ),
            ProductItem.Product(
                imageRes = R.drawable.adidas,
                name = "Adidas x Oasis",
                price = "Rp 1.600.000",
                size = "L"
            ),
            ProductItem.Product(
                imageRes = R.drawable.adidas_shoes,
                name = "Adidas Shoes X Oasis",
                price = "Rp 1.900.000",
                size = "45"
            ),
            ProductItem.Product(
                imageRes = R.drawable.converse,
                name = "Converse Chuck 70 Hi",
                price = "Rp 1.100.000",
                size = "42"
            )
        )

        val rvProducts = findViewById<RecyclerView>(R.id.rvProducts)
        rvProducts.layoutManager = GridLayoutManager(this, 2)
        rvProducts.adapter = ProductAdapter(productList, showSeller = false)


        val recyclerView = findViewById<RecyclerView>(R.id.rvSellers)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = SellerAdapter(sellerList) // GUNAKAN SellerAdapter

        val btnSignin = findViewById<MaterialButton>(R.id.btnSignin)
        btnSignin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.nav_home // tandai home aktif

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_profile -> {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(0, 0) // hilangkan animasi transisi (opsional)
                    true
                }
                R.id.nav_home -> true // tetap di HomePageGuest
                else -> false
            }
        }

>>>>>>> 69cba69b49969add8ed2e6e406c343aff1f5e869
    }
}