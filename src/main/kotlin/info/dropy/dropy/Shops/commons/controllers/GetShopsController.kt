package info.dropy.dropy.Shops.commons.controllers


import info.dropy.dropy.Shops.commons.data.Models.shop.Shop
import info.dropy.dropy.Shops.commons.services.ShopDetailsService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse


@RestController
@RequestMapping("api/v1/shops")
class GetShopsController @Autowired constructor(
    private val shopDetailsService: ShopDetailsService
    ){

    @GetMapping("all")
    fun getAllShop(response: HttpServletResponse): ResponseEntity<Any>{
        val shops = shopDetailsService.getAllShops()
        return ResponseEntity.ok()
            .body(shops)
    }


    @GetMapping("getshops/{id}")
    fun getIndividualShop(@PathVariable id: String): ResponseEntity<Any>{
        val shop = shopDetailsService.getShopDetails(id = id.toLong())
        return ResponseEntity.ok()
            .body(shop)
    }

    @GetMapping("getshops/{firebaseId}")
    fun getShopByFirebaseId(
        @PathVariable firebaseId:String?
    ): ResponseEntity<Shop?>{
        val shop = shopDetailsService.getShopDetailsByFirebaseId(firebase_id = firebaseId)
        return ResponseEntity.ok()
            .body(shop)
    }

}