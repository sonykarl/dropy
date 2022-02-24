package info.dropy.dropy.Customers.data.repositories

import info.dropy.dropy.Customers.data.models.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<Customer, Long> {
    fun findByEmail(email: String?): Customer?
    fun findById(id: Long?): Customer?
    fun findByFirebaseId(id:String): Customer?
    fun findByPhoneNumber(phoneNumber:String):Customer?
}