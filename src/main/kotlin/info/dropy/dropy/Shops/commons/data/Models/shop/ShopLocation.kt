package info.dropy.dropy.Shops.commons.data.Models.shop

import javax.persistence.*


@Entity
data class ShopLocation(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    @Column(name = "longitude")
    val longitude: Double,
    @Column(name = "latitude")
    val latitude: Double,
)