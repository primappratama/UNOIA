package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException

class LandPageActivity : AppCompatActivity() {

    private lateinit var googleSignInClient: GoogleSignInClient
    private val RC_SIGN_IN = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page)

        // Window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val videoView = findViewById<VideoView>(R.id.videoView)
        val videoUri = Uri.parse("android.resource://${packageName}/${R.raw.bgvideo}")
        videoView.setVideoURI(videoUri)

        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true
            mediaPlayer.setVolume(0f, 0f)

            // Hitung skala dan sesuaikan ukuran
            val screenWidth = resources.displayMetrics.widthPixels
            val screenHeight = resources.displayMetrics.heightPixels
            val videoWidth = mediaPlayer.videoWidth
            val videoHeight = mediaPlayer.videoHeight

            val scaleW = screenWidth.toFloat() / videoWidth
            val scaleH = screenHeight.toFloat() / videoHeight
            val scale = maxOf(scaleW, scaleH)

            val newWidth = (videoWidth * scale).toInt()
            val newHeight = (videoHeight * scale).toInt()

            val params = videoView.layoutParams
            params.width = newWidth
            params.height = newHeight
            videoView.layoutParams = params

            // Pusatkan video jika ukurannya lebih besar dari layar
            videoView.translationX = ((screenWidth - newWidth) / 2f)
            videoView.translationY = ((screenHeight - newHeight) / 2f)

            videoView.start()
        }


        // Google Sign-In config
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        // Tombol Google Login
        findViewById<Button>(R.id.btnGoogle).setOnClickListener {
            val signInIntent = googleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }

        // Login Email
        findViewById<TextView>(R.id.tvLogin).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        // Lewati ke Guest
        findViewById<TextView>(R.id.tvRegisterNanti).setOnClickListener {
            startActivity(Intent(this, HomepageGuestActivity::class.java))
        }

        // Daftar
        findViewById<Button>(R.id.btnSignup).setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                val name = account?.displayName
                val email = account?.email
                val photoUrl = account?.photoUrl

                Toast.makeText(this, "Hai $name!\nEmail: $email", Toast.LENGTH_LONG).show()

                val intent = Intent(this, HomepageGuestActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("email", email)
                intent.putExtra("photo", photoUrl.toString())
                startActivity(intent)
                finish()
            } catch (e: ApiException) {
                Toast.makeText(this, "Login Google gagal: ${e.statusCode}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
