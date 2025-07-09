package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import muchamadalfaidzin.informatika.tilas.adapter.SellerAdapter
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
                profileRes = R.drawable.profile,
                sellerName = "Eienorion"
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rvSellers)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = SellerAdapter(sellerList) // GUNAKAN SellerAdapter

        val btnSignin = findViewById<MaterialButton>(R.id.btnSignin)
        btnSignin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
