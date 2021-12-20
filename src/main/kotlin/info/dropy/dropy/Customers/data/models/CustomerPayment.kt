package info.dropy.dropy.Customers.data.models

import java.util.*
import javax.persistence.*

@Entity
data class CustomerPayment (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @ManyToOne
    val customer:Customer,
    @Column
    val paymentType: String,
    @Column
    val provider: String,
    @Column
    val accountNumber: Long,
    @Column
    val expiry: Date
        )