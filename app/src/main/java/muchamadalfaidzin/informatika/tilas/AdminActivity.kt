package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class AdminProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        findViewById<TextView>(R.id.btnManageUsers).setOnClickListener {
            Toast.makeText(this, "Navigating to Manage Users", Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, ManageUsersActivity::class.java))
        }

        findViewById<TextView>(R.id.btnManageProducts).setOnClickListener {
            Toast.makeText(this, "Navigating to Manage Products", Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, ManageProductsActivity::class.java))
        }

        findViewById<TextView>(R.id.btnViewTransactions).setOnClickListener {
            Toast.makeText(this, "Navigating to Transactions", Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, TransactionsActivity::class.java))
        }

        // ======== Bottom Navigation with Intents ========
        findViewById<LinearLayout>(R.id.nav_home)?.setOnClickListener {
            startActivity(Intent(this, HomepageMainActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.nav_search)?.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.nav_favorite)?.setOnClickListener {
            startActivity(Intent(this, FavoriteActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.nav_profile)?.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.nav_cart)?.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
        }
    }
