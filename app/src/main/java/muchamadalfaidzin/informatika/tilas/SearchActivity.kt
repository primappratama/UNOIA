package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search) // Pastikan ini dipanggil dulu

        // Baru kemudian akses view
        val mainView = findViewById<View>(R.id.searchView) // atau ID root view Anda
        ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
            // Kode penanganan insets Anda
            insets
        }

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