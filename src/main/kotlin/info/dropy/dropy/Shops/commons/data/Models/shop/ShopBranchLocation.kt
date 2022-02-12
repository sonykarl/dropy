package info.dropy.dropy.Shops.commons.data.Models.shop

import javax.persistence.*

@Entity
data class ShopBranchLocation (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @Column(name = "longitude")
    val longitude: Double,
    @Column(name = "latitude")
    val latitude: Double,
    @OneToOne
    @JoinColumn(name = "shopbranch_id")
    val shopbranch: ShopBranch
        )