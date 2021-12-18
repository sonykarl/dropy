package info.dropy.dropy.Shops.data

import javax.persistence.*

@Entity
data class Reviews (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    @Column
    val review: String
        )
