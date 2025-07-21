package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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

        setupViews()
    }

    private fun setupViews() {
        // Set up back button
        binding.btnBack.setOnClickListener {
            navigateToLogin()
        }

        // Set up text watcher for username/email field
        binding.etUsername.addTextChangedListener(createTextWatcher())

        // Set up reset password button
        binding.btnReset.setOnClickListener {
            resetPassword()
        }

        // Initially disable the reset button
        updateResetButtonState(false)
    }

    private fun createTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val isNotEmpty = s.toString().trim().isNotEmpty()
                updateResetButtonState(isNotEmpty)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }
    }

    private fun updateResetButtonState(isEnabled: Boolean) {
        binding.btnReset.isEnabled = isEnabled
        binding.btnReset.setBackgroundTintList(
            ContextCompat.getColorStateList(
                this,
                if (isEnabled) R.color.black else R.color.gray_e6
            )
        )
        binding.btnReset.setTextColor(
            ContextCompat.getColor(
                this,
                if (isEnabled) R.color.white else R.color.black30
            )
        )
    }

    private fun resetPassword() {
        val usernameOrEmail = binding.etUsername.text.toString().trim()

        // Validasi sederhana
        if (usernameOrEmail.isEmpty()) {
            binding.etUsername.error = "Masukkan username atau email"
            return
        }

        // Di sini biasanya akan ada logika untuk mengirim email reset password
        // Untuk sekarang kita hanya menampilkan toast dan navigasi ke login

        Toast.makeText(
            this,
            "Instruksi reset password telah dikirim ke email Anda",
            Toast.LENGTH_LONG
        ).show()

        navigateToLogin()
    }

    private fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}