package muchamadalfaidzin.informatika.tilas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
/*import muchamadalfaidzin.informatika.tilas.adapter.ProductAdapter*/
import muchamadalfaidzin.informatika.tilas.adapter.ProductHorizontalAdapter
import muchamadalfaidzin.informatika.tilas.adapter.SellerAdapter
import muchamadalfaidzin.informatika.tilas.model.NewArrivalAdapter
import muchamadalfaidzin.informatika.tilas.model.ProductItem
import muchamadalfaidzin.informatika.tilas.model.SellerItem

class HomepageMainActivity : AppCompatActivity() {

    private lateinit var recyclerNewArrival: RecyclerView
    private lateinit var adapter: NewArrivalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage_main)

        // New Arrival
        recyclerNewArrival = findViewById(R.id.recyclerNewArrival)
        val images = listOf(
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
        adapter = NewArrivalAdapter(images)
        recyclerNewArrival.layoutManager = GridLayoutManager(this, 3)
        recyclerNewArrival.adapter = adapter
    }
}