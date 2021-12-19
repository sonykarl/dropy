package info.dropy.dropy.Shops.data.ratings

import info.dropy.dropy.Customers.data.models.Customer
import info.dropy.dropy.Shops.data.shop.Shop
import java.sql.Date
import javax.persistence.*


@Entity
data class ShopRating (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @Column(name = "rating")
    val rating: Int,
    @ManyToOne
    val shop: Shop,
    @ManyToOne
    val customer: Customer,
    @Column(name = "reviews")
    val reviews: String,
    @Column(name = "review_date")
    val review_date: Date
)