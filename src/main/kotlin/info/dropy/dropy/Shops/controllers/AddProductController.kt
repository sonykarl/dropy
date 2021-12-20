package info.dropy.dropy.Shops.controllers

import info.dropy.dropy.Shops.data.Models.products.Product
import info.dropy.dropy.Shops.data.Models.products.ProductCategory
import info.dropy.dropy.Shops.data.Models.products.ProductRating
import info.dropy.dropy.Shops.data.Models.shop.Shop
import info.dropy.dropy.Shops.data.dtos.ProductDto
import info.dropy.dropy.Shops.services.AddProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.text.SimpleDateFormat
import java.util.*

@RestController
@RequestMapping("api/v1/shops/addproducts")
class AddProductController @Autowired constructor(val addProductService: AddProductService){

    @PostMapping
    fun addProducts(@RequestParam("file") file: MultipartFile, @RequestBody body: ProductDto){
        val simpleDateFormat = SimpleDateFormat("dd/M/yyy hh:mm:ss")
        val currentDate = simpleDateFormat.format(Date())
        val product = Product(category = ProductCategory(
            name = body.category, created_at = currentDate
        ), shop = , inventory = , photo =
            , description = body.description , created_at = currentDate, )
        addProductService.addProduct(file = file, product = product)
    }
}