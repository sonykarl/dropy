package info.dropy.dropy.Customers.data.orders

import javax.persistence.*


@Entity
data class OrderStatus(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @Column(name = "status")
    val status: String
    )