package muchamadalfaidzin.informatika.tilas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import muchamadalfaidzin.informatika.tilas.model.ShoppingBagItem

class ShoppingBagActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ShoppingBagAdapter
    private val shoppingBagItems = mutableListOf<ShoppingBagItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_bag)

        recyclerView = findViewById(R.id.rvshoppingbag)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Contoh data dummy
        shoppingBagItems.addAll(
            listOf(
                ShoppingBagItem(
                    imageRes = R.drawable.shirt1,
                    productName = "Skinny Jeans",
                    price = "Rp349.000",
                    quantity = 1,
                    color = "Blue",
                    size = "M",
                    total = "Rp349.000"
                ),
                ShoppingBagItem(
                    imageRes = R.drawable.shirt2,
                    productName = "Relaxed Fit Jeans",
                    price = "Rp319.000",
                    quantity = 2,
                    color = "Black",
                    size = "L",
                    total = "Rp638.000"
                )
            )
        )

        adapter = ShoppingBagAdapter(
            items = shoppingBagItems,
            onPlusClicked = { position ->
                shoppingBagItems[position].quantity++
                adapter.notifyItemChanged(position)
            },
            onMinusClicked = { position ->
                if (shoppingBagItems[position].quantity > 1) {
                    shoppingBagItems[position].quantity--
                    adapter.notifyItemChanged(position)
                }
            },
            onDeleteClicked = { position ->
                shoppingBagItems.removeAt(position)
                adapter.notifyItemRemoved(position)
            },
            onFavoriteClicked = { position ->
                // Tambahkan logika favorit di sini
            }
        )

        recyclerView.adapter = adapter
    }
}
