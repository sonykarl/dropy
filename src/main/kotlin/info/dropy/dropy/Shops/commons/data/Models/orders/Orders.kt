package info.dropy.dropy.Shops.commons.data.Models.orders

import info.dropy.dropy.Customers.data.models.Customer
import info.dropy.dropy.Shops.commons.data.Models.shop.Shop
import javax.persistence.*

@Entity
data class Orders (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val Id: Long = 0,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val customer: Customer,
    @Column(name = "orderdate")
    val orderDate: String,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val shop: Shop,
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val orderItems: List<OrderItem>?,
    @Column(name = "status")
    val status: String = "",
    @Column(name = "cost")
    val cost: Int
        )