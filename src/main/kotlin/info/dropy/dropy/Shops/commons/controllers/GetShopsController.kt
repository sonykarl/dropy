package info.dropy.dropy.Shops.commons.controllers

import com.mysql.cj.util.StringUtils.toString
import info.dropy.dropy.Shops.commons.data.Models.shop.Shop
import info.dropy.dropy.Shops.commons.data.dtos.GetShopByCategoryDto
import info.dropy.dropy.Shops.commons.data.dtos.ShopDetailsDto
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
    fun getShop(response: HttpServletResponse): ResponseEntity<Any>{
        val shops:List<Shop>? = shopDetailsService.getAllShops()
        val shopDetails = shops!!.forEach {
            shop: Shop ->
            val shopLogo = shop.shopLogo
            val shopname = shop.name
            val pathName = "C:\\Users\\wuodmogo\\IdeaProjects\\dropy\\dropy\\src\\main\\resources\\static\\shopslogoimages\\${shopLogo}"
            val inputStream = FileInputStream(File(pathName)) //loading the file
            val picString = String(inputStream.readAllBytes(), StandardCharsets.UTF_8)
//            val inputStreamResource = InputStreamResource(inputStream)
            val shopDetail = ShopDetailsDto(imageSrc = picString, shopName = shopname)
            return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,pathName)
                .body(shopDetail)
        }

        return ResponseEntity.ok()
            .body(shopDetails)

    }

}