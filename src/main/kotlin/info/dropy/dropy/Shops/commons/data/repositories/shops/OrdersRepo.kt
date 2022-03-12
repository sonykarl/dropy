package info.dropy.dropy.Shops.commons.data.repositories.shops


import info.dropy.dropy.Shops.commons.data.Models.orders.Orders
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrdersRepo: JpaRepository<Orders, Long> {
    fun findAllByShop(shopId:Long): List<Orders?>?
    fun findAllByCustomer(customerId:Long): List<Orders?>?
    fun findByStatusAndShop(status: String, shopId: Long):List<Orders?>
}