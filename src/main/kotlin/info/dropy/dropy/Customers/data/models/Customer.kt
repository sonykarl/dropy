package info.dropy.dropy.Customers.data.models

import javax.persistence.*

@Entity
data class Customer (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    @Column(name = "firstname")
    val firstName: String?,
    @Column(name="lastname")
    val lastName: String?,
    @Column(name="phone_number",unique = true)
    val phoneNumber: String?,
    @Column(name = "email",unique = true)
    val email: String?,
    @Column(name = "IsAccountLocked")
    val locked: Boolean? = false,
    @Column(name = "IsAccountExpired")
    val expired: Boolean? = false,
    @Column(name="IsAccountEnabled")
    val isEnabled:Boolean? = true,
    @Column
    val authority: String? = "CUSTOMER",
    @Column(name = "FirebaseId")
    val firebaseId: String? = null
        )