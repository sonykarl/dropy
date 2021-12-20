package info.dropy.dropy.Shops.data.Models.products

import info.dropy.dropy.Shops.data.Models.shop.Shop
import java.util.*
import javax.persistence.*

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    @ManyToOne(fetch = FetchType.LAZY)
    val category: ProductCategory,
    @ManyToOne(fetch = FetchType.LAZY)
    val shop: Shop,
    @ManyToOne(fetch = FetchType.LAZY)
    val inventory: ProductInventory,
    @Column(name = "photos")
    val photo: String,
    @Column
    val description: String,
    @OneToOne(fetch = FetchType.LAZY)
    val discount: Discount? = null,
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product")
    val productRating: List<ProductRating>? = null,
    @Column(name = "created_at")
    val created_at: String,
    @Column(name = "modified_at")
    val modified_at: String? = null,
    @Column(name = "deleted_at")
    val deleted_at: String? = null
)