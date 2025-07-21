package muchamadalfaidzin.informatika.tilas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.model.NewArrivalAdapter
import muchamadalfaidzin.informatika.tilas.SelectedCollectionAdapter
import muchamadalfaidzin.informatika.tilas.model.CollectionItem


class HomepageMainActivity : AppCompatActivity() {

    private lateinit var recyclerNewArrival: RecyclerView
    private lateinit var adapter: NewArrivalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage_main)

        // ======== 1. Setup RecyclerView NEW ARRIVAL ========
        val recyclerNewArrival = findViewById<RecyclerView>(R.id.recyclerNewArrival)
        val newArrivalImages = listOf(
            R.drawable.new1,
            R.drawable.new2,
            R.drawable.new3,
            R.drawable.new4,
            R.drawable.new5,
            R.drawable.new6,
            R.drawable.new7,
            R.drawable.new8,
            R.drawable.new9
        )

        recyclerNewArrival.layoutManager = GridLayoutManager(this, 3)
        recyclerNewArrival.adapter = NewArrivalAdapter(newArrivalImages)

        // ======== 2. Setup RecyclerView SELECTED COLLECTIONS ========
        val rvCollections = findViewById<RecyclerView>(R.id.rvCollections)
        val collectionList = listOf(
            CollectionItem(R.drawable.col1, "SHIRT & BLOUSES", "EXPLORE"),
            CollectionItem(R.drawable.col2, "JEANS", "EXPLORE"),
            CollectionItem(R.drawable.col3, "TROUSERS", "EXPLORE"),
            CollectionItem(R.drawable.col4, "BEST PRICE", "EXPLORE")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rvCollections)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = SelectedCollectionAdapter(collectionList)
    }
}