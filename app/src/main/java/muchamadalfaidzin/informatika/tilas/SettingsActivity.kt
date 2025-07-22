package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
/*import com.google.firebase.auth.FirebaseAuth*/

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Tombol Back
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Tombol Sign Out
        val btnSignOut = findViewById<TextView>(R.id.btnSignOut)
        btnSignOut.setOnClickListener {
            // Logout Firebase (kalau pakai)
            /*FirebaseAuth.getInstance().signOut()*/

            // Bersihin session lokal kalau ada (misal pakai SharedPreferences)
            val sharedPref = getSharedPreferences("UserSession", MODE_PRIVATE)
            val isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)

            if (isLoggedIn) {
                startActivity(Intent(this, HomepageMainActivity::class.java))
            } else {
                startActivity(Intent(this, LandPageActivity::class.java))
            }
            finish()
        }
    }
}
