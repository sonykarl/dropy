package info.dropy.dropy.Shops.commons.data.Models.shop

import javax.persistence.*

@Entity
data class ShopBranch(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @Column(name = "branchname")
    val name: String,
    @ManyToOne
    @JoinColumn(name = "shop_id")
    val shop: Shop,
    @OneToOne(mappedBy = "shopbranch", fetch = FetchType.LAZY)
    val shopBranchLocation: ShopBranchLocation,
    @Column(name = "phoneNumberOne")
    val phoneNumber: Long,
)
