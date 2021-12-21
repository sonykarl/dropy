package info.dropy.dropy.Shops.commons.data.Models.products

import info.dropy.dropy.Customers.data.models.Customer
import javax.persistence.*

@Entity
data class ProductRating(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @Column(name = "rating")
    val rating: Int,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    val customer: Customer,
    @ManyToOne
    @JoinColumn(name = "product_id")
    val product: Product
)