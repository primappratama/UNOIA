package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton

class SignupStep3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_step3)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val ivCheck = findViewById<ImageView>(R.id.ivCheck)
        val btnContinue = findViewById<MaterialButton>(R.id.btnSignup3)
        val btnBack = findViewById<ImageView>(R.id.btnBackSignup)

        etUsername.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val username = s.toString().trim()

                // Syarat: hanya huruf dan angka
                val valid = username.matches(Regex("^[a-zA-Z0-9]{3,}$"))

                if (valid) {
                    ivCheck.visibility = ImageView.VISIBLE
                    btnContinue.isEnabled = true
                    btnContinue.setTextColor(ContextCompat.getColor(this@SignupStep3Activity, android.R.color.white))
                    btnContinue.backgroundTintList = ContextCompat.getColorStateList(this@SignupStep3Activity, R.color.black)
                } else {
                    ivCheck.visibility = ImageView.GONE
                    btnContinue.isEnabled = false
                    btnContinue.setTextColor(ContextCompat.getColor(this@SignupStep3Activity, R.color.greySignup))
                    btnContinue.backgroundTintList = ContextCompat.getColorStateList(this@SignupStep3Activity, R.color.grey)
                }
            }
        })

        btnBack.setOnClickListener {
            finish()
        }

        btnContinue.setOnClickListener {
            val email = intent.getStringExtra("email")
            val name = intent.getStringExtra("name")
            val username = etUsername.text.toString().trim()

            val intent = Intent(this, SignupStep4Activity::class.java)
            intent.putExtra("email", email)
            intent.putExtra("name", name)
            intent.putExtra("username", username)
            startActivity(intent)
        }

    }
}
