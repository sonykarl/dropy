package info.dropy.dropy.Shops.commons.data.Models.orders

import info.dropy.dropy.Customers.data.orders.CustomerOrder
import javax.persistence.*

@Entity
data class Orderitemslist (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = 0,
        @Column(name = "quantity")
        val quantity: Int,
        @Column(name = "product")
        val product: Long,
        @Column(name = "customer")
        val customer: Long,
        @Column(name = "price")
        val price: Int?,
        @Column(name = "status")
        val status: String? = "unordered",
        @ManyToOne
        @JoinColumn(name = "fk_order")
        val order: CustomerOrder
        )