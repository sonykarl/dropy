package info.dropy.dropy.Shops.data

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
    @Column (name = "location")
    @ManyToMany
    val location: Location,
        )
