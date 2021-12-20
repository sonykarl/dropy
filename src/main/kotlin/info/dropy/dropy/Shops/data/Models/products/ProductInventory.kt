package info.dropy.dropy.Shops.data.Models.products

import java.util.*
import javax.persistence.*

@Entity
data class ProductInventory (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long = 0,
    @Column(name = "quantity")
    val quantity: Int,
    @Column(name = "created_at")
    val created_at: String,
    @Column(name = "modified_at")
    val modified_at: String? = null,
    @Column(name = "deleted_at")
    val deleted_at: String? = null
        )