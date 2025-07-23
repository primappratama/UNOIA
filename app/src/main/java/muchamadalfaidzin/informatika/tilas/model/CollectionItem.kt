package muchamadalfaidzin.informatika.tilas.model

data class CollectionItem(
    val imageResId: Int? = null,      // for drawable images
    val imageUri: String? = null,     // for gallery images
    val title: String,
    val price: String
)
