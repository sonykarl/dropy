package info.dropy.dropy.Shops.data.products

import java.util.*
import javax.persistence.*

@Entity
data class ProductInventory (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:String,
    @Column(name = "quantity")
    val quantity: Int,
    @Column(name = "created_at")
    val created_at: Date,
    @Column(name = "modified_at")
    val modified_at: Date,
    @Column(name = "deleted_at")
    val deleted_at: Date
        )