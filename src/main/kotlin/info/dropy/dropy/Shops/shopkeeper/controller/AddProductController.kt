package info.dropy.dropy.Shops.shopkeeper.controller

import info.dropy.dropy.Shops.commons.data.Models.products.Discount
import info.dropy.dropy.Shops.commons.data.Models.products.Product
import info.dropy.dropy.Shops.commons.data.Models.products.ProductCategory
import info.dropy.dropy.Shops.commons.data.Models.products.ProductInventory
import info.dropy.dropy.Shops.commons.data.dtos.ProductDto
import info.dropy.dropy.Shops.shopkeeper.services.AddProductService
import info.dropy.dropy.Shops.commons.services.ShopDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.text.SimpleDateFormat
import java.util.*

@RestController
@RequestMapping("api/v1/shopkeeper/addproducts")
class AddProductController @Autowired constructor(
    private val addProductService: AddProductService,
    private val shopDetailsService: ShopDetailsService
    ){

    @PostMapping
    fun addProducts(
        @RequestBody body: ProductDto
    ){
        val simpleDateFormat = SimpleDateFormat("dd/M/yyy hh:mm:ss")
        val currentDate = simpleDateFormat.format(Date())
        val getshop = shopDetailsService.getShopDetailsByFirebaseId(firebase_id = body.firebase_id)
        val product = Product(
            category = ProductCategory(
                name = body.category, created_at = currentDate
            ), shop = getshop,
            inventory = ProductInventory(
                quantity = body.inventory,
                created_at = currentDate
            ),
            photo = body.photo,
            description = body.description,
            discount = Discount(
                discount_percent = body.discount_percent,
                created_at = currentDate,
                discountcode = body.discount_code,
            ),
            created_at = currentDate,
            name = body.name,
            price = body.price
        )
        addProductService.addProduct( product = product)
    }
}