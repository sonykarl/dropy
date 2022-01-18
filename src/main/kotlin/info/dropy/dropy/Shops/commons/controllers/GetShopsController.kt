package info.dropy.dropy.Shops.commons.controllers

import info.dropy.dropy.Shops.commons.data.Models.shop.Shop
import info.dropy.dropy.Shops.commons.data.dtos.GetShopByCategoryDto
import info.dropy.dropy.Shops.commons.services.ShopDetailsService
import org.apache.tomcat.util.http.fileupload.IOUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.InputStreamResource
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File
import java.io.FileInputStream
import java.nio.file.Files
import java.nio.file.Paths
import javax.servlet.http.HttpServletResponse
import kotlin.reflect.full.memberProperties

@RestController
@RequestMapping("api/v1/shops")
class GetShopsController @Autowired constructor(
    private val shopDetailsService: ShopDetailsService
    ){
    @GetMapping("all")
    fun getShop(response: HttpServletResponse): ResponseEntity<Any>{
        val shops:List<Shop>? = shopDetailsService.getAllShops()

        val shopDetails = shops!!.forEach {
            shop: Shop ->
            val shopLogo = shop.shopLogo
            val pathName = "C:\\Users\\wuodmogo\\IdeaProjects\\dropy\\dropy\\src\\main\\resources\\static\\${shopLogo}"
            val inputStream = FileInputStream(File(pathName)) //loading the file
            val inputStreamResource = InputStreamResource(inputStream)
            return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .header(HttpHeaders.CONTENT_DISPOSITION,pathName)
                .body(inputStreamResource)
        }

        return ResponseEntity.ok()
            .body(shopDetails)

    }

}