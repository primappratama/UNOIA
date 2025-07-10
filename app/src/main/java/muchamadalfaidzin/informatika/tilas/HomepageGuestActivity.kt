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
import com.google.android.material.button.MaterialButton
import muchamadalfaidzin.informatika.tilas.adapter.ProductAdapter
import muchamadalfaidzin.informatika.tilas.adapter.SellerAdapter
import muchamadalfaidzin.informatika.tilas.model.ProductItem
import muchamadalfaidzin.informatika.tilas.model.SellerItem

class HomepageGuestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_homepage_guest)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ganti ProductItem.Seller ke SellerItem
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
    }
}
