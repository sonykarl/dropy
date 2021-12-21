package info.dropy.dropy.Shops.controllers

import info.dropy.dropy.Shops.data.Models.products.Discount
import info.dropy.dropy.Shops.data.Models.products.Product
import info.dropy.dropy.Shops.data.Models.products.ProductCategory
import info.dropy.dropy.Shops.data.Models.products.ProductInventory
import info.dropy.dropy.Shops.data.dtos.ProductDto
import info.dropy.dropy.Shops.services.AddProductService
import info.dropy.dropy.Shops.services.CategoryDetailsService
import info.dropy.dropy.Shops.services.ShopDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.text.SimpleDateFormat
import java.util.*

@RestController
@RequestMapping("api/v1/shops/addproducts")
class AddProductController @Autowired constructor(private val addProductService: AddProductService, private val shopDetailsService: ShopDetailsService){

    @PostMapping
    fun addProducts( @RequestBody body: ProductDto){
        val simpleDateFormat = SimpleDateFormat("dd/M/yyy hh:mm:ss")
        val currentDate = simpleDateFormat.format(Date())
        val getshop = shopDetailsService.getShopDetails(body.shop_email)
        val product = Product(category = ProductCategory(
            name = body.category, created_at = currentDate
        ), shop = getshop,
            inventory = ProductInventory(quantity = body.inventory, created_at = currentDate),
            photo = body.photo,
            description = body.description,
            discount = Discount(discount_percent = body.discount_percent, created_at = currentDate),
            created_at = currentDate
        )
        addProductService.addProduct( product = product)
    }
}