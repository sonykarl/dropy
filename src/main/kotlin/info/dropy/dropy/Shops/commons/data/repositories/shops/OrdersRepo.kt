package info.dropy.dropy.Shops.commons.data.repositories.shops

import info.dropy.dropy.Shops.commons.data.Models.orders.Orders
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrdersRepo: JpaRepository<Orders, Long> {
    fun findAllByShopId(shopId:Long): List<Orders>?
    fun findAllByCustomerId(customerId:Long): List<Orders>?
}