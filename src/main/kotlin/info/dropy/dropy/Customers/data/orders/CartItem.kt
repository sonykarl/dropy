package info.dropy.dropy.Customers.data.orders

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

data class CartItem (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
        )