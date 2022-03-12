package info.dropy.dropy.Customers.data.repositories

import info.dropy.dropy.Customers.data.orders.CustomerOrder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerOrderRepo: JpaRepository<CustomerOrder, Long>{
}