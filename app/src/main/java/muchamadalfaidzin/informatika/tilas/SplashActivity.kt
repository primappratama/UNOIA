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
            // Ganti ke activity utama kamu, misalnya LandPageActivity
            startActivity(Intent(this, LandPageActivity::class.java))
            finish()
        }, 2000) // 2000 ms = 2 detik
    }
}
