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
            // clear session
            val sharedPref = getSharedPreferences("user_session", MODE_PRIVATE)
            sharedPref.edit().clear().apply()

            // balik ke LandPage
            val intent = Intent(this, LandPageActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}
