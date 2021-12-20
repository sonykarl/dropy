package info.dropy.dropy.authentication.Shops.Controllers

import info.dropy.dropy.Shops.data.Models.shop.RetailCategory
import info.dropy.dropy.Shops.data.Models.shop.Shop
import info.dropy.dropy.Shops.services.AddShopService
import info.dropy.dropy.Shops.services.CategoryDetailsService
import info.dropy.dropy.authentication.Shops.dtos.Shopdto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/shops")
class ShopRegistrationController  @Autowired constructor(private val shopService: AddShopService,
                                                         private val categoryDetailsService: CategoryDetailsService) {


    @PostMapping("register")
    fun registerShop(@RequestBody body: Shopdto){

        val bodycategory = categoryDetailsService.getRetailCategory(body.category)?:RetailCategory(name = body.category)
        val shop = Shop(name = body.name, category = bodycategory, email = body.email)
        shopService.registerShop(shop, bodycategory)

    }
}
