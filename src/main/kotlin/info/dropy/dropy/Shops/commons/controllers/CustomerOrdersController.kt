package info.dropy.dropy.Shops.commons.controllers

import info.dropy.dropy.Shops.commons.data.Models.orders.OrderItem
import info.dropy.dropy.Shops.commons.services.OrderItemService
import info.dropy.dropy.authentication.Customer.data.OrderItemDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/customer/orders")
class CustomerOrdersController @Autowired constructor(
    private val orderItemService: OrderItemService
        ){

    @PostMapping("addOrderItem")
    fun addOrderItem(@RequestBody body: OrderItemDto){
        val orderItem = OrderItem(id = body.id, product = body.product, quantity = body.quantity)
        orderItemService.addOrderItem(orderItem = orderItem)
    }
}