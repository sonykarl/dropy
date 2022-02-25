package info.dropy.dropy.Customers.data.orders

import info.dropy.dropy.Customers.data.models.Customer
import java.util.*
import javax.persistence.*

@Entity
data class CustomerOrder(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @ManyToOne(fetch = FetchType.LAZY)
    val customer: Customer,
    @OneToOne(fetch = FetchType.LAZY)
    val status: OrderStatus,
    @Column(name = "date_placed")
    val date_placed: Date,
    @Column(name = "date_paid")
    val date_paid: Date,
    @Column (name = "total_price")
    val total_price: Int,
    @Column(name = "ordered_items")
    val other_order_details: String,
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerOrder")
    val ordered_products: List<CustomerOderedProduct>
)