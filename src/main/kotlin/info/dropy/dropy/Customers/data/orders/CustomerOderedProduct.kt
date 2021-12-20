package info.dropy.dropy.Customers.data.orders

import info.dropy.dropy.Shops.data.Models.products.Product
import javax.persistence.*

@Entity
data class CustomerOderedProduct(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @OneToOne(fetch = FetchType.LAZY)
    val product: Product,
    @Column(name = "quantity")
    val quantity: Int,
    @ManyToOne(fetch = FetchType.LAZY)
    val customerOrder: CustomerOrder
)