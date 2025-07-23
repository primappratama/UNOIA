package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.model.CollectionAdapter.CollectionAdapter
import muchamadalfaidzin.informatika.tilas.model.CollectionItem

class ShirtBlousesActivity : AppCompatActivity() {

    private lateinit var rvShirtBlouses: RecyclerView
    private lateinit var adapter: CollectionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shirt_blouses)

        rvShirtBlouses = findViewById(R.id.rvShirtBlouses)

        val defaultList = mutableListOf(
            CollectionItem(R.drawable.shirt1, null, "SHIRT & BLOUSES", "Rp199.000"),
            CollectionItem(R.drawable.shirt2, null, "CASUAL BLOUSE", "Rp259.000"),
            CollectionItem(R.drawable.shirt1, null, "FORMAL BLOUSE", "Rp299.000")
        )

        val productName = intent.getStringExtra("productName")
        val productPrice = intent.getStringExtra("productPrice")
        val productImageUri = intent.getStringExtra("productImage")

        if (productName != null && productPrice != null && productImageUri != null) {
            defaultList.add(
                CollectionItem(
                    imageUri = productImageUri,
                    title = productName,
                    price = "Rp$productPrice"
                )
            )
        }

        adapter = CollectionAdapter(defaultList)
        rvShirtBlouses.layoutManager = GridLayoutManager(this, 2)
        rvShirtBlouses.adapter = adapter

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            startActivity(Intent(this, HomepageMainActivity::class.java))
        }
    }
}