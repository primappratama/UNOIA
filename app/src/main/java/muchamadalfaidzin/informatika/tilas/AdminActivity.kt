package muchamadalfaidzin.informatika.tilas

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class AdminActivity : AppCompatActivity() {

    private lateinit var etProductName: EditText
    private lateinit var etPrice: EditText
    private lateinit var etColor: EditText
    private lateinit var spinnerSize: Spinner
    private lateinit var etDescription: EditText
    private lateinit var btnSubmit: MaterialButton
    private lateinit var imgUpload: ImageView

    private val PICK_IMAGE_REQUEST = 1
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        // Bind Views
        etProductName = findViewById(R.id.etProductName)
        etPrice = findViewById(R.id.etPrice)
        etColor = findViewById(R.id.etColor)
        spinnerSize = findViewById(R.id.spinnerSize)
        etDescription = findViewById(R.id.etDescription)
        btnSubmit = findViewById(R.id.btnSubmit)
        imgUpload = findViewById(R.id.imgUpload)

        // Spinner setup
        val sizeOptions = listOf("S", "M", "L", "XL")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, sizeOptions)
        spinnerSize.adapter = adapter

        // Upload image handler
        imgUpload.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        // Submit button handler
        btnSubmit.setOnClickListener {
            val name = etProductName.text.toString()
            val price = etPrice.text.toString()
            val color = etColor.text.toString()
            val size = spinnerSize.selectedItem.toString()
            val description = etDescription.text.toString()

            if (name.isEmpty() || price.isEmpty() || color.isEmpty() || description.isEmpty() || imageUri == null) {
                Toast.makeText(this, "Please fill all fields and upload a photo", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Product added:\n$name - $price - $color - $size", Toast.LENGTH_SHORT).show()
        }
    }

    // Handle result dari galeri
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            imageUri = data.data
            imgUpload.setImageURI(imageUri)
        }
    }
}
