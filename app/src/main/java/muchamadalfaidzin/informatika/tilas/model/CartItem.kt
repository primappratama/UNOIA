package muchamadalfaidzin.informatika.tilas.model

data class CartItem(
    val name: String,
    val color: String,
    val size: String,
    val price: String,
    val imageResId: Int,
    var quantity: Int
)
