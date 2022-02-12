package info.dropy.dropy.Shops.commons.data.Models.shop

import info.dropy.dropy.Customers.data.models.Customer
import javax.persistence.*

@Entity
data class CustomerFavourites (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val customer: Customer?,
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val shops: List<Shop>?
        )