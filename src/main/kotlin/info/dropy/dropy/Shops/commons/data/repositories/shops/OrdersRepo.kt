package info.dropy.dropy.Shops.commons.data.repositories.shops

import info.dropy.dropy.Customers.data.orders.OrderStatus
import info.dropy.dropy.Shops.commons.data.Models.orders.Orders
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface OrdersRepo: JpaRepository<Orders, Long> {
    fun findAllByShopId(shopId:Long): List<Orders?>?
    fun findAllByCustomerId(customerId:Long): List<Orders?>?
    @Query("SELECT * FROM ORDERS o WHERE O.status = :orderstatus AND o.shop_id = :shopId", nativeQuery = true)
    fun findOrdersByStatus(orderStatus: String, shopId: Long):List<Orders?>
}