package info.dropy.dropy.Shops.commons.data.Models.products

import java.util.*
import javax.persistence.*

@Entity
data class ProductCategory (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    @Column(name = "name")
    val name: String,
    @Column(name = "description")
    val description: String? = null,
    @Column(name = "created_at")
    val created_at: String,
    @Column(name = "modified_at")
    val modified_at: String? = null,
    @Column(name = "deleted_at")
    val deleted_at: String? = null
        )