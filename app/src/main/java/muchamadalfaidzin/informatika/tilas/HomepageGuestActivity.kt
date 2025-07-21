package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
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
import muchamadalfaidzin.informatika.tilas.model.CollectionItem
import muchamadalfaidzin.informatika.tilas.model.NewArrivalAdapter
import muchamadalfaidzin.informatika.tilas.model.ProductItem
import muchamadalfaidzin.informatika.tilas.model.SellerItem

class HomepageGuestActivity : AppCompatActivity() {

    private lateinit var recyclerNewArrival: RecyclerView
    private lateinit var adapter: NewArrivalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage_guest)

        // ======== 1. Setup RecyclerView NEW ARRIVAL ========
        val recyclerNewArrival = findViewById<RecyclerView>(R.id.recyclerNewArrival)
        val newArrivalImages = listOf(
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

        recyclerNewArrival.layoutManager = GridLayoutManager(this, 3)
        recyclerNewArrival.adapter = NewArrivalAdapter(newArrivalImages)

        // ======== 2. Setup RecyclerView SELECTED COLLECTIONS ========
        val rvCollections = findViewById<RecyclerView>(R.id.rvCollections)
        val collectionList = listOf(
            CollectionItem(R.drawable.col1, "SHIRT & BLOUSES", "EXPLORE"),
            CollectionItem(R.drawable.col2, "JEANS", "EXPLORE"),
            CollectionItem(R.drawable.col3, "TROUSERS", "EXPLORE"),
            CollectionItem(R.drawable.col4, "BEST PRICE", "EXPLORE")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rvCollections)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = SelectedCollectionAdapter(collectionList)

        // ======== Bottom Navigation with Intents ========
        findViewById<LinearLayout>(R.id.nav_home).setOnClickListener {
            startActivity(Intent(this, HomepageMainActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.nav_search).setOnClickListener {
            startActivity(Intent(this, LandPageActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.nav_favorite).setOnClickListener {
            startActivity(Intent(this, LandPageActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.nav_profile).setOnClickListener {
            startActivity(Intent(this, LandPageActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.nav_cart).setOnClickListener {
            startActivity(Intent(this, LandPageActivity::class.java))
        }
    }
}