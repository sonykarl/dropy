package info.dropy.dropy.Shops.commons.controllers

import info.dropy.dropy.Shops.commons.services.ShopDetailsService
import info.dropy.dropy.Shops.shopkeeper.services.OrdersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/shops/shoporders")
class ShopOrdersController @Autowired constructor(
    private val ordersService: OrdersService,
    private val shopDetailsService: ShopDetailsService
    ){

    @GetMapping("{shopId}")
    fun getShopOrders(@PathVariable shopId:String): ResponseEntity<Any>{
        val shopOrders = ordersService.getShopOrders(id = shopId!!.toLong())
        return ResponseEntity.ok()
            .body(shopOrders)
    }

    @GetMapping("shopfirebaseId/{firebaseId}")
    fun getMyShopOrders(
        @PathVariable firebaseId: String?
    ):ResponseEntity<Any>{
        val shop = shopDetailsService.getShopDetailsByFirebaseId(firebaseId)
        if (shop != null){
            val shopOrders = shop?.let { ordersService.getShopOrders(id = it.id) }
            return ResponseEntity.ok()
                .body(shopOrders)
        }else{
            return ResponseEntity.ok()
                .body(null)
        }

    }

    @GetMapping("shopordernumbers/{firebaseId}")
    fun getMyShopOrdersNumbers(
        @PathVariable firebaseId: String?
    ):ResponseEntity<Any>{
        val shop = shopDetailsService.getShopDetailsByFirebaseId(firebaseId)
        if (shop != null){
            val shopOrders = shop?.let { ordersService.getShopOrders(id = it.id) }
            val orderSize = shopOrders?.size
            return ResponseEntity.ok()
                .body(orderSize)
        }else{
            return ResponseEntity.ok()
                .body(null)
        }

    }
}