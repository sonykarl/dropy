package info.dropy.dropy.Shops.commons.data.dtos

import info.dropy.dropy.Customers.data.models.Customer
import info.dropy.dropy.Shops.commons.data.Models.orders.OrderItem
import info.dropy.dropy.Shops.commons.data.Models.shop.Shop

data class AddOrderDtop (
    val quantity: Int,
    val product: Long,
    val shop: Long,
    val customer: Long,
    val price: Int?,
    val status: String? = "unprocessed"
        )