package muchamadalfaidzin.informatika.tilas

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val btnSignup = findViewById<MaterialButton>(R.id.btnSignup)

        etEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val input = s.toString().trim()
                if (input.isNotEmpty()) {
                    // Email tidak kosong, aktifkan tombol dan ubah warnanya
                    btnSignup.isEnabled = true
                    btnSignup.setTextColor(ContextCompat.getColor(this@SignupActivity, android.R.color.white))
                    btnSignup.backgroundTintList = ContextCompat.getColorStateList(this@SignupActivity, R.color.black)
                } else {
                    // Email kosong, nonaktifkan tombol
                    btnSignup.isEnabled = false
                    btnSignup.setTextColor(ContextCompat.getColor(this@SignupActivity, R.color.greySignup))
                    btnSignup.backgroundTintList = ContextCompat.getColorStateList(this@SignupActivity, R.color.grey)
                }
            }
        })

    }
}