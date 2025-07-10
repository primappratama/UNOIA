package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import muchamadalfaidzin.informatika.tilas.databinding.ActivityForgotBinding

class ForgotActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etUsername.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val isNotEmpty = s.toString().trim().isNotEmpty()
                binding.btnReset.isEnabled = isNotEmpty
                binding.btnReset.setBackgroundTintList(
                    ContextCompat.getColorStateList(
                        this@ForgotActivity,
                        if (isNotEmpty) R.color.black else R.color.gray_e6
                    )
                )
                binding.btnReset.setTextColor(
                    ContextCompat.getColor(
                        this@ForgotActivity,
                        if (isNotEmpty) R.color.white else R.color.black30
                    )
                )
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        val btnReset = findViewById<Button>(R.id.btnReset)

        btnReset.setOnClickListener {
            Toast.makeText(this, "Password telah berhasil reset", Toast.LENGTH_SHORT).show()


            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        val btnBack = findViewById<ImageView>(R.id.btnBackSignup)
        btnBack.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}
