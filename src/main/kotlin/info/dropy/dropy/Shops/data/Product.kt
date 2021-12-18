package info.dropy.dropy.Shops.data

import javax.persistence.*

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    @Column
    @ManyToMany
    val category: Category,
    @Column
    val description: String
)