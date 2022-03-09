package info.dropy.dropy.Shops.commons.controllers

import info.dropy.dropy.Customers.Service.CustomerDataServices
import info.dropy.dropy.Shops.commons.data.Models.orders.OrderItem
import info.dropy.dropy.Shops.commons.data.Models.orders.Orders
import info.dropy.dropy.Shops.commons.services.OrderItemService
import info.dropy.dropy.Shops.commons.services.OrdersCustomerService
import info.dropy.dropy.authentication.Customer.data.OrderItemDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/customer/orders")
class CustomerOrdersController @Autowired constructor(
    private val orderItemService: OrderItemService,
    private val ordersService: OrdersCustomerService,
    private val customerDataServices: CustomerDataServices
        ){

    @PostMapping("addOrderItem")
    fun addOrderItem(@RequestBody body: OrderItemDto){
        val orderItem = OrderItem(
            quantity = body.quantity,
            product = body.product,
            customer = body.customer,
            shop = body.shop
        )
        orderItemService.addOrderItem(orderItem)
    }

    @PostMapping("addOrder")
    fun addOrder(@RequestBody order:Orders){
        ordersService.addOrder(order = order)
    }

    @GetMapping("customerOrderItems/{customerId}")
    fun getCustomerOrdersItems(
        @PathVariable customerId:Long
    ): ResponseEntity<Any>{
        val orderItems =  orderItemService.getCustomerOrderItems(customerId)
        return ResponseEntity.ok()
            .body(orderItems)

    }
    @GetMapping("getAllOrderItems")
    fun getAllOrderItems():ResponseEntity<Any>{
        val allItems = orderItemService.getAllItems()
        return ResponseEntity.ok()
            .body(allItems)
    }
}
