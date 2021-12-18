package info.dropy.dropy.Shops.data

import javax.persistence.*

@Entity
data class Category (
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    val id: Long = 0,
    @Column(name = "string")
    val name: String
        )
