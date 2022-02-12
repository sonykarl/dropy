package info.dropy.dropy.authentication.Customer.data

import info.dropy.dropy.Customers.data.models.Customer
import info.dropy.dropy.Shops.commons.data.Models.products.Product
import info.dropy.dropy.Shops.commons.data.Models.shop.Shop

data class OrderItemDto (
    val id: Long,
    val product: Product,
    val quantity: Int,
    val customer: Customer,
    val shop: Shop
        )