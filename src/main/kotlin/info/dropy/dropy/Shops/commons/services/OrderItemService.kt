package info.dropy.dropy.Shops.commons.services

import info.dropy.dropy.Customers.data.orders.CustomerOrder
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

    fun getAllItems():List<OrderItem?>{
        return orderItemRepo.findAll()
    }

    fun getCustomerOrderItems(customer:Long):List<OrderItem?>{
        return orderItemRepo.findByCustomer(customer)
    }

    fun deleteOrderItem(orderItem: OrderItem){
        orderItemRepo.delete(orderItem)
    }

    fun getShopOrderItems(shop:Long):List<OrderItem?>{
        return orderItemRepo.findByShop(shop)
    }

    fun deleteAll(){
        orderItemRepo.deleteAll()
    }



}