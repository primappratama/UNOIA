package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AlphaAnimation
import androidx.appcompat.app.AppCompatActivity
import muchamadalfaidzin.informatika.tilas.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo1 = findViewById<View>(R.id.logo1)
        val logo2 = findViewById<View>(R.id.logo2)

        // Tampilkan logo1 dulu (default udah visible di XML)

        Handler(Looper.getMainLooper()).postDelayed({
            // Animasi fade out untuk logo1
            val fadeOut = AlphaAnimation(1f, 0f).apply {
                duration = 500
                fillAfter = true
            }

            // Animasi fade in untuk logo2
            val fadeIn = AlphaAnimation(0f, 1f).apply {
                duration = 500
                fillAfter = true
            }

            logo1.startAnimation(fadeOut)
            logo1.visibility = View.GONE

            logo2.visibility = View.VISIBLE
            logo2.startAnimation(fadeIn)

        }, 1500)

        // Setelah 3 detik lanjut ke halaman utama
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LandPageActivity::class.java))
            finish()
        }, 3000)
    }
}
