package info.dropy.dropy.Shops.commons.controllers

import info.dropy.dropy.Customers.Service.CustomerDataServices
import info.dropy.dropy.Shops.commons.data.Models.orders.OrderItem
import info.dropy.dropy.Shops.commons.data.Models.orders.Orders
import info.dropy.dropy.Shops.commons.data.dtos.AddOrderDtop
import info.dropy.dropy.Shops.commons.services.OrderItemService
import info.dropy.dropy.Shops.commons.services.OrdersCustomerService
import info.dropy.dropy.authentication.Customer.data.OrderItemDto
import org.hibernate.criterion.Order
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.text.SimpleDateFormat
import java.util.*

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
            shop = body.shop,
            price = body.price
        )
        orderItemService.addOrderItem(orderItem)
    }

    @PutMapping("confirmOrder")
    fun confirmOrder(@RequestBody body: AddOrderDtop){

        val orderItem = OrderItem(
            quantity = body.quantity,
            product = body.product,
            customer = body.customer,
            shop = body.shop,
            price = body.price,
            status = body.status
        )
        orderItemService.addOrderItem(orderItem)
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

    @DeleteMapping("deleteOrderItem")
    fun deleteOrder(
        @RequestBody body:OrderItem
    ){
        orderItemService.deleteOrderItem(body)
    }
}
