package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val sharedPref = getSharedPreferences("user_session", MODE_PRIVATE)

            val isLoggedIn = sharedPref.contains("username") && sharedPref.contains("user_id")

            if (isLoggedIn) {
                startActivity(Intent(this, HomepageMainActivity::class.java))
            } else {
                startActivity(Intent(this, LandPageActivity::class.java))
            }

            finish()
        }, 2000) // Delay 2 detik biar ada waktu liat logo
    }
}
