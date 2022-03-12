package info.dropy.dropy.Shops.commons.data.dtos

import info.dropy.dropy.Customers.data.models.Customer
import info.dropy.dropy.Shops.commons.data.Models.orders.OrderItem
import info.dropy.dropy.Shops.commons.data.Models.shop.Shop

data class AddOrderDtop (
    val customer: Customer,
    val shop: Shop,
    val orderItems: List<OrderItem>,
    val status: String = "unprocessed",
    val cost: Int
        )