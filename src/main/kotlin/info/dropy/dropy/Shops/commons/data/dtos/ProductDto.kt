package info.dropy.dropy.Shops.commons.data.dtos



data class ProductDto (
    val category: String = "tech",
    val inventory: Int = 1,
    val firebase_id: String?,
    val description: String,
    val discount_percent: Float,
    val discount_code: String? = null,
    val name: String,
    val price: Int?,
    val photo: String
        )