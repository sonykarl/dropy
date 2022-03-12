package info.dropy.dropy.Shops.commons.data.dtos

import info.dropy.dropy.Customers.data.models.Customer
import info.dropy.dropy.Shops.commons.data.Models.orders.OrderItem
import info.dropy.dropy.Shops.commons.data.Models.orders.Orderitemslist


data class AddCustomerOrderDto (
    val customer: Long,
    val status: String,
    val total_price:Int,
    val other_order_details:String,
    val ordered_products:List<OrderItem?> = listOf(),
    val shop: Int
    )