package info.dropy.dropy.Shops.data.Models.products

import java.util.*
import javax.persistence.*

@Entity
data class Discount (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @Column(name = "name")
    val name: String,
    @Column(name = "description")
    val description: String,
    @Column(name = "discount_percent")
    val discount_percent: Double,
    @Column(name = "active")
    val active: Boolean,
    @Column(name = "created_at")
    val created_at: Date,
    @Column(name = "modified_at")
    val modified_at: Date,
    @Column(name = "deleted_at")
    val deleted_at: Date
        )