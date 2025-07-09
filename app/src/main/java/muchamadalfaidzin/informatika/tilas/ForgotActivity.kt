package muchamadalfaidzin.informatika.tilas

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
    }
}
