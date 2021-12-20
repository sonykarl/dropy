package info.dropy.dropy.Customers.data.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class CustomerAddress (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
        )