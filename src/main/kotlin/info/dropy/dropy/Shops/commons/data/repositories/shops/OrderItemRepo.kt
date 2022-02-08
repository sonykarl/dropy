package info.dropy.dropy.Shops.commons.data.repositories.shops

import info.dropy.dropy.Shops.commons.data.Models.orders.OrderItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderItemRepo: JpaRepository<OrderItem, Long> {
}