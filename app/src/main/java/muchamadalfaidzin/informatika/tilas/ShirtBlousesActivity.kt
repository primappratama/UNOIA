package muchamadalfaidzin.informatika.tilas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.model.CollectionItem

class ShirtBlousesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shirt_blouses)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvShirtBlouses = findViewById<RecyclerView>(R.id.rvShirtBlouses)
        val collectionList = listOf(
            CollectionItem(R.drawable.col1, "SHIRT & BLOUSES", "EXPLORE"),
            CollectionItem(R.drawable.col2, "JEANS", "EXPLORE"),
            CollectionItem(R.drawable.col3, "TROUSERS", "EXPLORE"),
            CollectionItem(R.drawable.col4, "BEST PRICE", "EXPLORE")
        )
        rvShirtBlouses.layoutManager = GridLayoutManager(this, 2)
        rvShirtBlouses.adapter = SelectedCollectionAdapter(collectionList)
    }
}