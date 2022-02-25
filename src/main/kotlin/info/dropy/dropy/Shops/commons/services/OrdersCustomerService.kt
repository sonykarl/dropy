package info.dropy.dropy.Shops.commons.services

import info.dropy.dropy.Shops.commons.data.Models.orders.Orders
import info.dropy.dropy.Shops.commons.data.repositories.shops.OrdersRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class OrdersCustomerService @Autowired constructor(
    val ordersRepo: OrdersRepo
){
    fun addOrder(order: Orders){
        ordersRepo.save(order)
    }
}