package info.dropy.dropy.Shops.commons.data.Models.orders

import info.dropy.dropy.Customers.data.models.Customer
import info.dropy.dropy.Shops.commons.data.Models.shop.Shop
import javax.persistence.*

@Entity
data class Orders (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val Id: Long = 0,
    val customer: Long,
    @Column(name = "orderdate")
    val orderDate: String,
    @Column(name = "shop")
    val shop: Long,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val orderItems: OrderItem,
    @Column(name = "status")
    val status: String = "",
    @Column(name = "cost")
    val cost: Int
        )