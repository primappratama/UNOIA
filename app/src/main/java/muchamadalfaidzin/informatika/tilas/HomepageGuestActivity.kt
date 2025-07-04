package muchamadalfaidzin.informatika.tilas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.adapter.SellerAdapter
import muchamadalfaidzin.informatika.tilas.model.Seller

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

        val rvSellers = findViewById<RecyclerView>(R.id.rvSellers)

        val sellerList = listOf(
            Seller(R.drawable.item1, R.drawable.item2, R.drawable.item3, R.drawable.profile, "Jzevanya"),
            Seller(R.drawable.item4, R.drawable.item7, R.drawable.item6, R.drawable.profile, "Jzevanya")
        )

        rvSellers.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvSellers.adapter = SellerAdapter(sellerList)
    }
}
