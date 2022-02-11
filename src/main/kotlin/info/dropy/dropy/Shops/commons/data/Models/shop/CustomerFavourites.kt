package info.dropy.dropy.Shops.commons.data.Models.shop

import info.dropy.dropy.Customers.data.models.Customer
import javax.persistence.*

@Entity
data class Favourites (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    @Column
    val shop: Shop?,
    @Column
    val customer: Customer?,
        )