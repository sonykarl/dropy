package info.dropy.dropy.Shops.commons.data.dtos

import info.dropy.dropy.Customers.data.models.Customer
import info.dropy.dropy.Shops.commons.data.Models.orders.OrderItem


data class AddCustomerOrderDto (
    val customer: Customer,
    val status: String,
    val date_placed:String,
    val date_paid:String,
    val total_price:Int,
    val other_order_details:String,
    val ordered_products:List<OrderItem>,
    val shop: Int
    )