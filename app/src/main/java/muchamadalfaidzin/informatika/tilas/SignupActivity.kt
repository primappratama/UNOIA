package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class SignupActivity : AppCompatActivity() {
    private lateinit var etEmail: EditText
    private lateinit var btnSignup: MaterialButton
    private lateinit var btnBackSignup: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inisialisasi elemen UI
        etEmail = findViewById(R.id.etEmail)
        btnSignup = findViewById(R.id.btnSignup)
        btnBackSignup = findViewById(R.id.btnBackSignup)

        // Tombol Back
        btnBackSignup.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Validasi email
        etEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val input = s.toString().trim()
                if (input.isNotEmpty()) {
                    btnSignup.isEnabled = true
                    btnSignup.setTextColor(ContextCompat.getColor(this@SignupActivity, android.R.color.white))
                    btnSignup.backgroundTintList = ContextCompat.getColorStateList(this@SignupActivity, R.color.black)
                } else {
                    btnSignup.isEnabled = false
                    btnSignup.setTextColor(ContextCompat.getColor(this@SignupActivity, R.color.greySignup))
                    btnSignup.backgroundTintList = ContextCompat.getColorStateList(this@SignupActivity, R.color.grey)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        // Tombol Continue → Lanjut ke Step 2
        btnSignup.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val intent = Intent(this, SignupStep2Activity::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }
    }
}
