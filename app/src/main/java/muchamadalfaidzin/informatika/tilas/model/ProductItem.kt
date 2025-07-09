package muchamadalfaidzin.informatika.tilas.model

sealed class ProductItem {
    data class Product(
        val imageRes: Int,
        val name: String,
        val price: String,
        val size: String
    ) : ProductItem()

    data class Seller(
        val item1: Int,
        val item2: Int,
        val item3: Int,
        val profileImage: Int,
        val name: String
    ) : ProductItem()

    data class HorizontalSection(
        val products: List<Product>
    ) : ProductItem()


}




