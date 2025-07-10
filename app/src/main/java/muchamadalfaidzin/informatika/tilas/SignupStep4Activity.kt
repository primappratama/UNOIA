package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton

class SignupStep4Activity : AppCompatActivity() {

    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_step4)

        val etPassword = findViewById<EditText>(R.id.etPassword)
        val ivToggle = findViewById<ImageView>(R.id.ivTogglePassword)
        val tvMinLength = findViewById<TextView>(R.id.tvMinLength)
        val tvNumber = findViewById<TextView>(R.id.tvNumber)
        val tvUppercase = findViewById<TextView>(R.id.tvUppercase)
        val btnContinue = findViewById<MaterialButton>(R.id.btnSignup3)

        // Tombol awal nonaktif
        btnContinue.isEnabled = false

        // Show/hide password
        ivToggle.setOnClickListener {
            if (isPasswordVisible) {
                etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                ivToggle.setImageResource(R.drawable.ic_eye_closed)
            } else {
                etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                ivToggle.setImageResource(R.drawable.ic_eye_open)
            }
            etPassword.setSelection(etPassword.text.length)
            isPasswordVisible = !isPasswordVisible
        }

        // Validasi password
        etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val password = s.toString()

                val checkIcon = ContextCompat.getDrawable(this@SignupStep4Activity, R.drawable.ic_check)
                val closeIcon = ContextCompat.getDrawable(this@SignupStep4Activity, R.drawable.ic_close)

                var isValidLength = false
                var hasNumber = false
                var hasUpper = false

                // Minimal 8 karakter
                if (password.length >= 8) {
                    isValidLength = true
                    tvMinLength.setTextColor(ContextCompat.getColor(this@SignupStep4Activity, R.color.green))
                    tvMinLength.setCompoundDrawablesWithIntrinsicBounds(checkIcon, null, null, null)
                } else {
                    tvMinLength.setTextColor(ContextCompat.getColor(this@SignupStep4Activity, R.color.grey))
                    tvMinLength.setCompoundDrawablesWithIntrinsicBounds(closeIcon, null, null, null)
                }

                // Mengandung angka
                if (password.any { it.isDigit() }) {
                    hasNumber = true
                    tvNumber.setTextColor(ContextCompat.getColor(this@SignupStep4Activity, R.color.green))
                    tvNumber.setCompoundDrawablesWithIntrinsicBounds(checkIcon, null, null, null)
                } else {
                    tvNumber.setTextColor(ContextCompat.getColor(this@SignupStep4Activity, R.color.grey))
                    tvNumber.setCompoundDrawablesWithIntrinsicBounds(closeIcon, null, null, null)
                }

                // Mengandung huruf besar
                if (password.any { it.isUpperCase() }) {
                    hasUpper = true
                    tvUppercase.setTextColor(ContextCompat.getColor(this@SignupStep4Activity, R.color.green))
                    tvUppercase.setCompoundDrawablesWithIntrinsicBounds(checkIcon, null, null, null)
                } else {
                    tvUppercase.setTextColor(ContextCompat.getColor(this@SignupStep4Activity, R.color.grey))
                    tvUppercase.setCompoundDrawablesWithIntrinsicBounds(closeIcon, null, null, null)
                }

                // Jika semua valid, aktifkan tombol
                if (isValidLength && hasNumber && hasUpper) {
                    btnContinue.isEnabled = true
                    btnContinue.setBackgroundTintList(ContextCompat.getColorStateList(this@SignupStep4Activity, android.R.color.black))
                    btnContinue.setTextColor(ContextCompat.getColor(this@SignupStep4Activity, android.R.color.white))
                } else {
                    btnContinue.isEnabled = false
                    btnContinue.setBackgroundTintList(ContextCompat.getColorStateList(this@SignupStep4Activity, R.color.grey))
                    btnContinue.setTextColor(ContextCompat.getColor(this@SignupStep4Activity, R.color.greySignup))
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        // Aksi tombol Continue
        btnContinue.setOnClickListener {
            val email = intent.getStringExtra("email") ?: ""
            val name = intent.getStringExtra("name") ?: ""
            val username = intent.getStringExtra("username") ?: ""
            val password = etPassword.text.toString()

            val db = Database.AppDatabase.getInstance(this)
            val userDao = db.userDao()

            Thread {
                val existingUser = userDao.checkUserExist(email, username)
                if (existingUser != null) {
                    runOnUiThread {
                        Toast.makeText(this, "Email atau Username sudah digunakan", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    val newUser = entity.UserEntity(
                        nama = name,
                        username = username,
                        email = email,
                        password = password
                    )

                    userDao.insertUser(newUser)

                    runOnUiThread {
                        Toast.makeText(this, "Anda Berhasil Membuat Akun!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }.start()
        }
        val btnBackSignup = findViewById<ImageView>(R.id.btnBackSignup)
        btnBackSignup.setOnClickListener {
            val intent = Intent(this, SignupStep3Activity::class.java)
            startActivity(intent)
        }

    }
}
