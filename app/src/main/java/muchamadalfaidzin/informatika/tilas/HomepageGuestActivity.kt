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
import muchamadalfaidzin.informatika.tilas.adapter.ProductAdapter
import muchamadalfaidzin.informatika.tilas.model.ProductItem

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

        val recyclerView = findViewById<RecyclerView>(R.id.rvSellers)

        val dataList = listOf(
            ProductItem.Seller(
                item1 = R.drawable.item1,
                item2 = R.drawable.item2,
                item3 = R.drawable.item3,
                profileImage = R.drawable.profile,
                name = "Jzevanya"
            ),
            ProductItem.Seller(
                item1 = R.drawable.item4,
                item2 = R.drawable.item7,
                item3 = R.drawable.item6,
                profileImage = R.drawable.profile,
                name = "Eienorion"
            )
        )

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = ProductAdapter(dataList, showSeller = true)

        val btnSignin = findViewById<MaterialButton>(R.id.btnSignin)

        btnSignin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}
