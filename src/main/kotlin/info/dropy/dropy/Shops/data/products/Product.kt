package info.dropy.dropy.Shops.data.products

import info.dropy.dropy.Shops.data.shop.RetailCategory
import javax.persistence.*

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category")
    val category: RetailCategory,
    @Column
    val description: String,
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product")
    val productRating: List<ProductRating>
)