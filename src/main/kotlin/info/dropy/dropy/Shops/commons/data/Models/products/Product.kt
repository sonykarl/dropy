package info.dropy.dropy.Shops.commons.data.Models.products

import info.dropy.dropy.Shops.commons.data.Models.shop.Shop
import java.util.*
import javax.persistence.*

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    @Column(name = "name")
    val name: String,
    @Column (name = "price")
    val price: Int,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val category: ProductCategory,
    @ManyToOne(fetch = FetchType.LAZY,cascade = [CascadeType.ALL])
    val shop: Shop?,
    @ManyToOne(fetch = FetchType.LAZY,cascade = [CascadeType.ALL])
    val inventory: ProductInventory,
    @Column(name = "photos")
    val photo: String?,
    @Column
    val description: String,
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
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