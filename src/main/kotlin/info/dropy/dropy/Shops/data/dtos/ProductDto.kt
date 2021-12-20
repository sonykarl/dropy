package info.dropy.dropy.Shops.data.dtos

import info.dropy.dropy.Shops.data.Models.products.ProductCategory
import java.util.*

data class ProductDto (
    val category: String,
    val inventory: Int,
    val shop_id: Long,
    val description: String,
    val discount_percent: Float,
    val created_at: Date,
        )