package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.CartActivity
import muchamadalfaidzin.informatika.tilas.FavoriteActivity
import muchamadalfaidzin.informatika.tilas.ProfileActivity
import muchamadalfaidzin.informatika.tilas.R
import muchamadalfaidzin.informatika.tilas.SearchActivity
import muchamadalfaidzin.informatika.tilas.SelectedCollectionAdapter
import muchamadalfaidzin.informatika.tilas.model.CollectionItem
import muchamadalfaidzin.informatika.tilas.model.NewArrivalAdapter

class HomepageMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage_main)

        // ======== Setup RecyclerView NEW ARRIVAL ========
        val recyclerNewArrival = findViewById<RecyclerView>(R.id.recyclerNewArrival)
        val newArrivalImages = listOf(
            R.drawable.new1, R.drawable.new2, R.drawable.new3,
            R.drawable.new4, R.drawable.new5, R.drawable.new6,
            R.drawable.new7, R.drawable.new8, R.drawable.new9
        )
        recyclerNewArrival.layoutManager = GridLayoutManager(this, 3)
        recyclerNewArrival.adapter = NewArrivalAdapter(newArrivalImages)

        // ======== Setup RecyclerView SELECTED COLLECTIONS ========
        val rvCollections = findViewById<RecyclerView>(R.id.rvCollections)
        val collectionList = listOf(
            CollectionItem(R.drawable.col1, "SHIRT & BLOUSES", "EXPLORE"),
            CollectionItem(R.drawable.col2, "JEANS", "EXPLORE"),
            CollectionItem(R.drawable.col3, "TROUSERS", "EXPLORE"),
            CollectionItem(R.drawable.col4, "BEST PRICE", "EXPLORE")
        )
        rvCollections.layoutManager = GridLayoutManager(this, 2)
        rvCollections.adapter = SelectedCollectionAdapter(collectionList)

        // ======== Bottom Navigation with Intents ========
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

