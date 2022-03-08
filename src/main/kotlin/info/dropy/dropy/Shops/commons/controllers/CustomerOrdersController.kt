package info.dropy.dropy.Shops.commons.controllers

import info.dropy.dropy.Customers.Service.CustomerDataServices
import info.dropy.dropy.Shops.commons.data.Models.orders.OrderItem
import info.dropy.dropy.Shops.commons.data.Models.orders.Orders
import info.dropy.dropy.Shops.commons.services.OrderItemService
import info.dropy.dropy.Shops.commons.services.OrdersCustomerService
import info.dropy.dropy.authentication.Customer.data.OrderItemDto
import jdk.jpackage.internal.Log
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
        val customer = body.customerFirebaseId?.let { customerDataServices.findByFirebaseId(it) }
        val orderItem = customer?.let { OrderItem(id = body.id, product = body.product, quantity = body.quantity, customer = it,shop = body.shop) }
        if (orderItem != null) {
            orderItemService.addOrderItem(orderItem = orderItem)
        }else{
            Log.error("Error in addingOrderitem")
        }
    }

    @GetMapping("getOrderItems")
    fun getOrderItems(@PathVariable customerId:String): ResponseEntity<Any>{
        val customerOrderItems = orderItemService.getOrderItems(customerId = customerId.toLong())
        return ResponseEntity.ok()
            .body(customerOrderItems)
    }

    @PostMapping("addOrder")
    fun addOrder(@RequestBody order:Orders){
        ordersService.addOrder(order = order)
    }
}
