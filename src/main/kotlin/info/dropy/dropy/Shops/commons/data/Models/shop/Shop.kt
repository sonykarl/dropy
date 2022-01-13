package info.dropy.dropy.Shops.commons.data.Models.shop

import javax.persistence.*

@Entity
data class Shop (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long = 0,
    @Column(name = "name")
    val name:String,
    @Column(name = "email", unique = true)
    val email: String,
    @ManyToOne(fetch = FetchType.LAZY)
    val category: RetailCategory?,
    @Column(name = "logo")
    val shopLogo: String
    )