package info.dropy.dropy.Customers.data.repositories

import info.dropy.dropy.Customers.data.models.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<Customer, Long> {
    fun findByEmail(email: String): Customer?
}