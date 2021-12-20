package info.dropy.dropy.Shops.data.Models.Location

import info.dropy.dropy.Shops.data.Models.shop.Shop
import javax.persistence.*

@Entity
data class Address (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    @Column (name = "streetAddress")
    val streetAddress: String,
    @Column (name = "landmarkBuilding")
    val landMarkBuilding: String,
    @Column (name = "latitude")
    val lat: Double,
    @Column (name = "longitude")
    val long: Double,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address")
    val shop: Shop
        )
