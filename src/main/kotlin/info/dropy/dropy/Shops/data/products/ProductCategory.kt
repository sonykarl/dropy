package info.dropy.dropy.Shops.data.products

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class ProductCategory (
    @Id
    val id: Long,
    @Column(name = "categoryname")
    val name: String,
    @Column(name = "description")
    val description: String,
    @Column(name = "created_at")
    val created_at: Date,
    @Column(name = "modified_at")
    val modified_at: Date,
    @Column(name = "deleted_at")
    val deleted_at: Date
        )