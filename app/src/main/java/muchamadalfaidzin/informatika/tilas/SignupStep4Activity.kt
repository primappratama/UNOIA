package muchamadalfaidzin.informatika.tilas

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

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

        // Show/Hide password
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

        // Password Validation
        etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val password = s.toString()

                // 1. Minimal 8 karakter
                if (password.length >= 8) {
                    tvMinLength.text = "✅ Minimal 8 karakter"
                    tvMinLength.setTextColor(ContextCompat.getColor(this@SignupStep4Activity, R.color.green))
                } else {
                    tvMinLength.text = "❌ Minimal 8 karakter"
                    tvMinLength.setTextColor(ContextCompat.getColor(this@SignupStep4Activity, R.color.grey))
                }

                // 2. Mengandung angka
                if (password.any { it.isDigit() }) {
                    tvNumber.text = "✅ Mengandung angka"
                    tvNumber.setTextColor(ContextCompat.getColor(this@SignupStep4Activity, R.color.green))
                } else {
                    tvNumber.text = "❌ Mengandung angka"
                    tvNumber.setTextColor(ContextCompat.getColor(this@SignupStep4Activity, R.color.grey))
                }

                // 3. Mengandung huruf besar
                if (password.any { it.isUpperCase() }) {
                    tvUppercase.text = "✅ Mengandung huruf besar"
                    tvUppercase.setTextColor(ContextCompat.getColor(this@SignupStep4Activity, R.color.green))
                } else {
                    tvUppercase.text = "❌ Mengandung huruf besar"
                    tvUppercase.setTextColor(ContextCompat.getColor(this@SignupStep4Activity, R.color.grey))
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}
