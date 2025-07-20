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

        // Delay splash selama 2 detik
        Handler(Looper.getMainLooper()).postDelayed({
            val sharedPref = getSharedPreferences("user_session", MODE_PRIVATE)

            // ✅ Cek apakah sudah login berdasarkan data SharedPreferences
            val isLoggedIn = sharedPref.contains("username") && sharedPref.contains("user_id")

            if (isLoggedIn) {
                // Sudah login → langsung ke homepage
                startActivity(Intent(this, HomepageMainActivity::class.java))
            } else {
                // Belum login → ke LandPage
                startActivity(Intent(this, LandPageActivity::class.java))
            }

            // Selesai splash
            finish()
        }, 2000) // 2 detik
    }
}
