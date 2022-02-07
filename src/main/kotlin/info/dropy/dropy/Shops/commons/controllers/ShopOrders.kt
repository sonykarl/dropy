package info.dropy.dropy.Shops.commons.controllers

import info.dropy.dropy.Shops.shopkeeper.services.OrdersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/shops/shoporders")
class ShopOrders @Autowired constructor(
    private val ordersService: OrdersService
    ){

    @GetMapping("{shopId}")
    fun getShopOrders(@PathVariable shopId:String): ResponseEntity<Any>{
        val shopOrders = ordersService.getShopOrders(id = shopId!!.toLong())
        return ResponseEntity.ok()
            .body(shopOrders)
    }
}