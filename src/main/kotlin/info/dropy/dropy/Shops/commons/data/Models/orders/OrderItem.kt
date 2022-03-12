package info.dropy.dropy.Shops.commons.data.Models.orders

import info.dropy.dropy.Customers.data.models.Customer
import info.dropy.dropy.Customers.data.orders.CustomerOrder
import info.dropy.dropy.Shops.commons.data.Models.products.Product
import info.dropy.dropy.Shops.commons.data.Models.shop.Shop
import javax.persistence.*

@Entity
data class OrderItem(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    @Column(name = "quantity")
    val quantity: Int,
    @Column(name = "product")
    val product: Long,
    @Column(name = "shop")
    val shop: Long,
    @Column(name = "customer")
    val customer: Long,
    @Column(name = "price")
    val price: Int?,
    @Column(name = "status")
    val status: String? = "unordered",
    @ManyToOne
    @JoinColumn(name = "customer_order_id")
    val customerOrder: CustomerOrder? = null
    )