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
    val shopLogo: String? = null,
    @Column(name = "header")
    val shopHeader: String? = null,
    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY)
    val shopbranch: List<ShopBranch>?,
    @Column(name ="latitude")
    val latitude: Double? = null,
    @Column(name = "longitude")
    val longitude: Double? = null,
    @Column(name = "phoneNumberOne")
    val phoneNumber: Long?,
    @Column(name = "phoneNumberTwo")
    val firebaseId: String?
)