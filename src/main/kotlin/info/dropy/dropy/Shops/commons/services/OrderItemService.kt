package info.dropy.dropy.Shops.commons.services

import info.dropy.dropy.Shops.commons.data.Models.orders.OrderItem
import info.dropy.dropy.Shops.commons.data.repositories.shops.OrderItemRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderItemService @Autowired constructor(
    private val orderItemRepo: OrderItemRepo
){
    fun addOrderItem(orderItem: OrderItem){
        orderItemRepo.save(orderItem)
    }
}