package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.model.CartAdapter
import muchamadalfaidzin.informatika.tilas.model.CartItem

class CartActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cartAdapter: CartAdapter
    private lateinit var cartItems: MutableList<CartItem>
    private lateinit var btnCheckout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        recyclerView = findViewById(R.id.recyclerShoppingBag)
        btnCheckout = findViewById(R.id.btnCheckout)

        recyclerView.layoutManager = LinearLayoutManager(this)

        cartItems = mutableListOf(
            CartItem("BASIC T-SHIRT", "White", "XXL", "IDR 99.900", R.drawable.shirt1, 1),
            CartItem("BASIC SWEATER", "Black", "M", "IDR 149.900", R.drawable.shirt2, 2)
        )

        cartAdapter = CartAdapter(cartItems)
        recyclerView.adapter = cartAdapter

        // 🔽 Tampilkan tombol hanya jika isi keranjang tidak kosong
        btnCheckout.visibility = if (cartItems.isNotEmpty()) View.VISIBLE else View.GONE

        btnCheckout.setOnClickListener {
            // Tambahkan aksi checkout di sini
        }

        // Navigasi bottom bar
        findViewById<LinearLayout>(R.id.nav_home).setOnClickListener {
            startActivity(Intent(this, HomepageMainActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.nav_search).setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.nav_favorite).setOnClickListener {
            startActivity(Intent(this, FavoriteActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.nav_profile).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.nav_cart).setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
    }
}
