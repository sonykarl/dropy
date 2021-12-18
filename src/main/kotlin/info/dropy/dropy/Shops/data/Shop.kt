package info.dropy.dropy.Shops.data

import javax.persistence.*

@Entity
data class Shop (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long = 0,
    @Column(name = "name")
    val name:String,
    @JoinColumn(name = "address")
    val address: Address,
    @JoinColumn (name = "reviews")
    val reviews: Reviews,
    @JoinColumn (name = "rating")
    val rating: Rating,
    @JoinColumn (name = "operatingHours")
    val operatingTimes: OperatingTimes
)