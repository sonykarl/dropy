package info.dropy.dropy.Shops.commons.data.Models.shop

import javax.persistence.*

@Entity
data class WeekdaysOperatingTimes (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @Column(name = "openingHours")
    val openingHours: Double,
    @Column(name = "closingHours")
    val closingHours: Double
        )
