package info.dropy.dropy.Customers.data.repositories

import info.dropy.dropy.Shops.commons.data.Models.orders.Orderitemslist
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemslistrepo:JpaRepository<Orderitemslist, Long> {
}