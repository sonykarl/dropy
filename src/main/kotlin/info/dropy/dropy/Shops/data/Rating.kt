package info.dropy.dropy.Shops.data

import javax.persistence.*


@Entity
data class Rating (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @Column(name = "rating")
    val rating: Int
        )
