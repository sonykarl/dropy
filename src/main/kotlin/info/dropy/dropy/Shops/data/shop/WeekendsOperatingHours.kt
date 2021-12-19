package info.dropy.dropy.Shops.data.shop

import javax.persistence.*

@Entity
data class WeekendsOperatingHours (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @Column(name = "openingHours")
    val openingHours: Double,

        )