package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.model.CollectionAdapter.CollectionAdapter
import muchamadalfaidzin.informatika.tilas.model.CollectionItem

class TrousersActivity : AppCompatActivity() {

    private lateinit var rvtrouser: RecyclerView
    private lateinit var adapter: CollectionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trouser)

        rvtrouser= findViewById(R.id.rvtrouser)

        val list = listOf(
            CollectionItem(R.drawable.shirt1, "SKINNY JEANS", "Rp349.000"),
            CollectionItem(R.drawable.shirt2, "HIGH-WAIST JEANS", "Rp399.000"),
            CollectionItem(R.drawable.shirt1, "RELAXED FIT JEANS", "Rp319.000")
        )

        adapter = CollectionAdapter(list)
        rvtrouser.layoutManager = GridLayoutManager(this, 2)
        rvtrouser.adapter = adapter

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            startActivity(Intent(this, HomepageMainActivity::class.java))
        }
    }
}
