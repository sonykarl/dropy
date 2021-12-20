package info.dropy.dropy.Shops.data.Models.shop

import javax.persistence.*

@Entity
data class Shop (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long = 0,
    @Column(name = "name")
    val name:String,
    @ManyToOne(fetch = FetchType.LAZY)
    val category: RetailCategory
    )