package info.dropy.dropy.Shops.data

import javax.persistence.*

@Entity
data class Shop (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long = 0,
    @Column(name = "name")
    val name:String,
    @Column(name = "address")
    val address: Address,
    @Column (name = "review")
    @OneToMany
    val reviews: Reviews,
    @Column (name = "rating")
    @OneToMany
    val rating: Rating,
    @Column (name = "operatingTimes")
    @OneToOne
    val operatingTimes: OperatingTimes
)