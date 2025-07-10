package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton

class SignupStep2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_step2)

        val email = intent.getStringExtra("email")  // Email dari step sebelumnya
        val etName = findViewById<EditText>(R.id.etNama)
        val btnNext = findViewById<MaterialButton>(R.id.btnSignup2)

        // Default tombol nonaktif
        btnNext.isEnabled = false
        btnNext.setTextColor(ContextCompat.getColor(this, R.color.greySignup))
        btnNext.backgroundTintList = ContextCompat.getColorStateList(this, R.color.grey)

        // Aktifkan tombol saat nama diisi
        etName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val input = s.toString().trim()
                if (input.isNotEmpty()) {
                    btnNext.isEnabled = true
                    btnNext.setTextColor(ContextCompat.getColor(this@SignupStep2Activity, android.R.color.white))
                    btnNext.backgroundTintList = ContextCompat.getColorStateList(this@SignupStep2Activity, R.color.black)
                } else {
                    btnNext.isEnabled = false
                    btnNext.setTextColor(ContextCompat.getColor(this@SignupStep2Activity, R.color.greySignup))
                    btnNext.backgroundTintList = ContextCompat.getColorStateList(this@SignupStep2Activity, R.color.grey)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        // Lanjut ke Step 3 jika nama tidak kosong
        btnNext.setOnClickListener {
            val name = etName.text.toString().trim()
            if (name.isNotEmpty()) {
                val intent = Intent(this, SignupStep3Activity::class.java)
                intent.putExtra("email", email)
                intent.putExtra("name", name)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }

        val btnBackSignup = findViewById<ImageView>(R.id.btnBackSignup)
        btnBackSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

    }
}
