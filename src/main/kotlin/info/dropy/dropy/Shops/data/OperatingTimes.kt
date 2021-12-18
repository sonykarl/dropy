package info.dropy.dropy.Shops.data

import javax.persistence.*

@Entity
data class OperatingTimes (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @Column(name = "openingHours")
    val openingHours: Double,
    @Column(name = "closingHours")
    val closingHours: Double
        )
