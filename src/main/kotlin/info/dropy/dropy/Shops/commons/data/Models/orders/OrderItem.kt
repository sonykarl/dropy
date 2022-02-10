package info.dropy.dropy.Shops.commons.data.Models.orders

import info.dropy.dropy.Customers.data.models.Customer
import info.dropy.dropy.Shops.commons.data.Models.products.Product
import javax.persistence.*

@Entity
data class OrderItem(
    @Id
    val id: Long,
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val product: Product,
    @Column(name = "quantity")
    val quantity: Int,
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val customer: Customer,
)