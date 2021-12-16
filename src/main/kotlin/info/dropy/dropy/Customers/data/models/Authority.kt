package info.dropy.dropy.Customers.data.models

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

data class Authority(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int,
    val name:String
)
