package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import Database.AppDatabase

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)
        val tvLupaPassword = findViewById<TextView>(R.id.tvLupapassword)
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        btnBack.setOnClickListener {
            startActivity(Intent(this, LandPageActivity::class.java))
        }

        tvLupaPassword.setOnClickListener {
            startActivity(Intent(this, ForgotActivity::class.java))
        }

        btnLogin.setOnClickListener {
            val inputUser = etUsername.text.toString().trim()
            val inputPassword = etPassword.text.toString().trim()

            if (inputUser.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(this, "Isi username dan password terlebih dahulu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val db = AppDatabase.getInstance(this)
            val userDao = db.userDao()

            Thread {
                val user = userDao.login(inputUser, inputPassword)
                runOnUiThread {
                    if (user != null) {
                        // ✅ Simpan data login ke SharedPreferences
                        val sharedPref = getSharedPreferences("user_session", MODE_PRIVATE)
                        with(sharedPref.edit()) {
                            putString("username", user.username)
                            putString("nama", user.nama)
                            putInt("user_id", user.id)
                            apply()
                        }

                        Toast.makeText(this, "Login berhasil, selamat datang ${user.nama}", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, HomepageMainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "Login gagal, data tidak ditemukan", Toast.LENGTH_SHORT).show()
                    }
                }
            }.start()
        }
    }
}