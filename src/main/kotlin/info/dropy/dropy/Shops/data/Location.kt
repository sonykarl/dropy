package info.dropy.dropy.Shops.data

import javax.persistence.*

@Entity
data class Location(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    @Column(name = "lat")
    val lat: Double,
    @Column (name = "long")
    val long: Double
)
