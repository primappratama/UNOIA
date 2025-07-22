package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.adapter.FavoriteAdapter
import muchamadalfaidzin.informatika.tilas.data.FavoriteStorage

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_favorite)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.favoriteView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ===== View Binding Manual =====
        val rvFavorites = findViewById<RecyclerView>(R.id.rvFavorites)
        val subtitle = findViewById<TextView>(R.id.tv_fav_subtitle)
        val desc = findViewById<TextView>(R.id.tv_fav_desc)
        val explore = findViewById<Button>(R.id.btn_explore)

        val favorites = FavoriteStorage.favorites

        if (favorites.isNotEmpty()) {
            // Jika ada data favorit
            subtitle.visibility = View.GONE
            desc.visibility = View.GONE
            explore.visibility = View.GONE
            rvFavorites.visibility = View.VISIBLE

            rvFavorites.layoutManager = LinearLayoutManager(this)
            rvFavorites.adapter = FavoriteAdapter(favorites)
        } else {
            // Jika tidak ada data favorit
            subtitle.visibility = View.VISIBLE
            desc.visibility = View.VISIBLE
            explore.visibility = View.VISIBLE
            rvFavorites.visibility = View.GONE
        }

        // ===== Bottom Navigation =====
        findViewById<LinearLayout>(R.id.nav_home).setOnClickListener {
            startActivity(Intent(this, HomepageMainActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.nav_search).setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.nav_favorite).setOnClickListener {
            // do nothing
        }

        findViewById<LinearLayout>(R.id.nav_profile).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.nav_cart).setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
    }
}
