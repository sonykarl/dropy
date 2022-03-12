package info.dropy.dropy.Customers.data.orders

import info.dropy.dropy.Customers.data.models.Customer
import info.dropy.dropy.Shops.commons.data.Models.orders.OrderItem
import info.dropy.dropy.Shops.commons.data.Models.orders.Orderitemslist
import javax.persistence.*

@Entity
data class CustomerOrder(
    @Id
    val id: Long = 0,
    @Column(name = "customer")
    val customer: Long,
    @Column(name = "status")
    val status: String,
    @Column(name = "date_placed")
    val date_placed: String,
    @Column(name = "date_paid")
    val date_paid: String,
    @Column (name = "total_price")
    val total_price: Int,
    @Column(name = "ordered_items")
    val other_order_details: String,
    @OneToMany
    @JoinColumn(name = "fk_order")
    val ordered_products: List<OrderItem?> = listOf(),
    @Column(name = "shop")
    val shop: Int
)