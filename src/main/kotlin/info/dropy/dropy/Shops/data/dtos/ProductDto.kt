package info.dropy.dropy.Shops.data.dtos

import info.dropy.dropy.Shops.data.Models.products.ProductCategory
import org.springframework.web.multipart.MultipartFile
import java.util.*

data class ProductDto (
    val category: String,
    val inventory: Int,
    val shop_email: String,
    val description: String,
    val discount_percent: Float,
        )