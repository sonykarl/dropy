package info.dropy.dropy.Shops.data.shop

import javax.persistence.*

@Entity

data class RetailCategory (
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    val id: Long = 0,
    @Column(name = "category_name")
    val name: String,
        )
