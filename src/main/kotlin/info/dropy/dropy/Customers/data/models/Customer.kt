package info.dropy.dropy.Customers.data.models

import javax.persistence.*

@Entity
data class Customer (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    @Column(name = "firstname")
    val firstName: String,
    @Column(name="lastname")
    val lastName: String,
    @Column(name="phone_number",unique = true)
    val phoneNumber: Long,
    @Column(name = "email",unique = true)
    val email: String,
    @Column(name = "password")
    val password: String
        )