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
            val isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)

            if (isLoggedIn) {
                // Sudah login → langsung ke Homepage
                startActivity(Intent(this, HomepageMainActivity::class.java))
            } else {
                // Belum login → ke LandPage
                startActivity(Intent(this, LandPageActivity::class.java))
            }
            finish()
        }, 2000) // 2 detik splash delay
    }
}
