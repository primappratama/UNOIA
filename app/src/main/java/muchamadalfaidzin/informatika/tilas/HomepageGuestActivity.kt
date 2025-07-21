package muchamadalfaidzin.informatika.tilas

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import muchamadalfaidzin.informatika.tilas.adapter.SellerAdapter
import muchamadalfaidzin.informatika.tilas.model.NewArrivalAdapter
import muchamadalfaidzin.informatika.tilas.model.ProductItem
import muchamadalfaidzin.informatika.tilas.model.SellerItem

class HomepageGuestActivity : AppCompatActivity() {

    private lateinit var recyclerNewArrival: RecyclerView
    private lateinit var adapter: NewArrivalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage_guest)

        recyclerNewArrival = findViewById(R.id.recyclerNewArrival)

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

        adapter = NewArrivalAdapter(newArrivalImages)
        recyclerNewArrival.layoutManager = GridLayoutManager(this, 3)
        recyclerNewArrival.adapter = adapter

    }
}
