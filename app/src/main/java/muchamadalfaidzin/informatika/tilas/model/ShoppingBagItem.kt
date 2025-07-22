package muchamadalfaidzin.informatika.tilas.model

data class ShoppingBagItem(
    val imageRes: Int,
    val productName: String,
    val price: String,
    val color: String,
    val size: String,
    val total: String,
    var quantity: Int
)
