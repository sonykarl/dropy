package info.dropy.dropy.Shops.commons.controllers

import info.dropy.dropy.Shops.commons.data.Models.shop.Shop
import info.dropy.dropy.Shops.commons.data.dtos.GetShopByCategoryDto
import info.dropy.dropy.Shops.commons.services.ShopDetailsService
import org.apache.tomcat.util.http.fileupload.IOUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File
import java.io.FileInputStream
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("api/v1/shops")
class GetShopsController @Autowired constructor(
    private val shopDetailsService: ShopDetailsService
    ){
    @GetMapping("all")
    fun getShops(response: HttpServletResponse){
        val inputStream = FileInputStream(File("C:\\Users\\wuodmogo\\IdeaProjects\\dropy\\dropy\\src\\main\\resources\\static\\shopslogoimageslabel.PNG")) //loading the file
        IOUtils.copy(inputStream,response.outputStream)
        response.flushBuffer()
    }
}