package info.dropy.dropy.Shops.data.shop

import info.dropy.dropy.Shops.data.Location.Address
import javax.persistence.*

@Entity
data class Shop (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long = 0,
    @Column(name = "name")
    val name:String,
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "shop")
    val address: List<Address>,
    @ManyToMany
    val category: List<RetailCategory>
    )