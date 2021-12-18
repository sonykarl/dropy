package info.dropy.dropy.Shops.data

import javax.persistence.*

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    @JoinColumn(name = "category")
    val category: Category,
    @Column
    val description: String
)