package info.dropy.dropy.Shops.commons.data.repositories.shops

import info.dropy.dropy.Shops.commons.data.Models.orders.OrderItem
import info.dropy.dropy.Shops.commons.data.Models.products.Product
import org.hibernate.criterion.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface OrderItemRepo: JpaRepository<OrderItem, Long> {
    fun findByCustomer(customer:Long):List<OrderItem?>
    fun findByShop(shop:Long):List<OrderItem?>
}