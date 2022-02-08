package info.dropy.dropy.authentication.Customer.data

import info.dropy.dropy.Shops.commons.data.Models.products.Product

data class OrderItemDto (
    val id: Long,
    val product: Product,
    val quantity: Int
        )