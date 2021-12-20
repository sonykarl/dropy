package info.dropy.dropy.authentication.Shops.Controllers

import info.dropy.dropy.Shops.data.Models.shop.RetailCategory
import info.dropy.dropy.Shops.data.Models.shop.Shop
import info.dropy.dropy.Shops.services.AddShopService
import info.dropy.dropy.authentication.Shops.dtos.Shopdto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/shop")
class ShopRegistrationController  @Autowired constructor(private val shopService: AddShopService) {

    @PostMapping("register")
    fun registerShop(@RequestBody body: Shopdto){
        val category = RetailCategory(name = body.category)
        val shop = Shop(name = body.name, category = category)
        shopService.registerShop(shop, category)
    }
}
