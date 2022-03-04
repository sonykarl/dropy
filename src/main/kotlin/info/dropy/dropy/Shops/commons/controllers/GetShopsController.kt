package info.dropy.dropy.Shops.commons.controllers


import info.dropy.dropy.Shops.commons.services.ShopDetailsService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.lang.Character.toString
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.util.Arrays.toString
import javax.servlet.http.HttpServletResponse
import kotlin.reflect.full.memberProperties

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
//    @GetMapping("popularShops")
//    fun getPopularShops(response: HttpServletResponse): ResponseEntity<Any>{
//        val shops = shopDetailsService
//    }

    @GetMapping("{id}")
    fun getIndividualShop(@PathVariable id: String): ResponseEntity<Any>{
        val shop = shopDetailsService.getShopDetails(id = id.toLong())
        return ResponseEntity.ok()
            .body(shop)
    }

    @GetMapping("{firebaseId}")
    fun getShopByFirebaseId(@PathVariable firebaseId:String?): ResponseEntity<Any>{
        val shop = shopDetailsService.getShopDetailsByFirebaseId(firebase_id = firebaseId)
        return ResponseEntity.ok()
            .body(shop)
    }

}