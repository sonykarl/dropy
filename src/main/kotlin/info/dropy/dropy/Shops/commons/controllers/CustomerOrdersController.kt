package info.dropy.dropy.Shops.commons.controllers

import info.dropy.dropy.Customers.Service.CustomerOrderService
import info.dropy.dropy.Customers.data.orders.CustomerOrder
import info.dropy.dropy.Shops.commons.data.Models.orders.OrderItem
import info.dropy.dropy.Shops.commons.data.dtos.AddCustomerOrderDto
import info.dropy.dropy.Shops.commons.data.dtos.AddOrderDtop
import info.dropy.dropy.Shops.commons.services.OrderItemService
import info.dropy.dropy.authentication.Customer.data.OrderItemDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.text.SimpleDateFormat
import java.util.*

@RestController
@RequestMapping("api/v1/customer/orders")
class CustomerOrdersController @Autowired constructor(
    private val orderItemService: OrderItemService,
    private val customerOrderService: CustomerOrderService

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

    @PostMapping("addcustomerorder")
    fun addCustomerOrder(
        @RequestBody body: AddCustomerOrderDto
    ){
        val simpleDateFormat = SimpleDateFormat("dd/M/yyy hh:mm:ss")
        val currentDate = simpleDateFormat.format(Date())
        customerOrderService.addCustomerOrder(order = CustomerOrder(
            customer = body.customer,
            status = body.status,
            date_paid = currentDate,
            date_placed = currentDate,
            total_price = body.total_price,
            other_order_details = body.other_order_details,
            ordered_products = body.ordered_products,
            shop = body.shop
        ))
    }

    @GetMapping("getorderitemsshop/{shopId}")
    fun getShopOrderItems(
        @PathVariable shopId:Long
    ):ResponseEntity<Any>{

        val orderitems = orderItemService.getShopOrderItems(shopId)
        return ResponseEntity.ok()
            .body(orderitems)
    }

    @GetMapping("getAllOrders")
    fun getAllOrders():ResponseEntity<Any>{
        val orders = customerOrderService.getAllOrders()
        return ResponseEntity.ok()
            .body(orders)
    }
}
