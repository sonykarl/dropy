package info.dropy.dropy.Shops.data.products

import info.dropy.dropy.Shops.data.shop.RetailCategory
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
    val inventory: ProductInventory,
    @Column
    val description: String,
    @OneToOne(fetch = FetchType.LAZY)
    val discount: Discount,
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product")
    val productRating: List<ProductRating>,
    @Column(name = "created_at")
    val created_at: Date,
    @Column(name = "modified_at")
    val modified_at: Date,
    @Column(name = "deleted_at")
    val deleted_at: Date
)