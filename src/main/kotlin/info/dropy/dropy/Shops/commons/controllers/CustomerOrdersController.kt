package info.dropy.dropy.Shops.commons.controllers

import info.dropy.dropy.Customers.Service.CustomerOrderService
import info.dropy.dropy.Customers.data.orders.CustomerOrder
import info.dropy.dropy.Shops.commons.data.Models.orders.OrderItem
import info.dropy.dropy.Shops.commons.data.Models.orders.Orders
import info.dropy.dropy.Shops.commons.data.dtos.AddCustomerOrderDto
import info.dropy.dropy.Shops.commons.data.dtos.AddOrderDtop
import info.dropy.dropy.Shops.commons.services.OrderItemService
import info.dropy.dropy.Shops.commons.services.OrdersCustomerService
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
    private val ordersCustomerService: OrdersCustomerService

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

    @PostMapping("addedcustomer/customerorder")
    fun addCustomerOrder(
        @RequestBody body: AddCustomerOrderDto
    ):String{
        val simpleDateFormat = SimpleDateFormat("dd/M/yyy hh:mm:ss")
        val currentDate = simpleDateFormat.format(Date()).toString()
        val order = Orders(
            customer = body.customer,
            status = body.status,
            orderDate = currentDate,
            shop = body.shop.toLong(),
            orderItems = body.ordered_products,
            cost = body.total_price
        )
        ordersCustomerService.addOrder(order)
        return "order done"
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
        val orders = ordersCustomerService.getOrders().size
        return ResponseEntity.ok()
            .body(orders)
    }

    @GetMapping("getbystatusandshop/{status}/{shopId}")
    fun getbystatusandshop(
        @PathVariable("status")status:String,
        @PathVariable("shopId")shopId: Long
    ): ResponseEntity<Any>{
        val orderslists  = ordersCustomerService.getOrdersbystatusandcustomer(status = status, shop = shopId)
        return ResponseEntity.ok()
            .body(orderslists)
    }
}
