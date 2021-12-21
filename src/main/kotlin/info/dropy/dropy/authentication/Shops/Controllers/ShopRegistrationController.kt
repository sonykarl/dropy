package info.dropy.dropy.authentication.Shops.Controllers

import info.dropy.dropy.Shops.shopkeeper.services.AddShopService
import info.dropy.dropy.Shops.commons.services.CategoryDetailsService
import info.dropy.dropy.Shops.commons.services.ShopDetailsService
import info.dropy.dropy.authentication.Shops.dtos.Shopdto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/shops")
class ShopRegistrationController  @Autowired constructor(private val shopService: AddShopService,
                                                         private val shopDetailsService: ShopDetailsService,
                                                         private val categoryDetailsService: CategoryDetailsService
) {


    @PostMapping("register")
    fun registerShop(@RequestBody body: Shopdto): String{

        val bodycategory = categoryDetailsService.getRetailCategory(body.category)?: info.dropy.dropy.Shops.commons.data.Models.shop.RetailCategory(
            name = body.category
        )
        val emailExists = shopDetailsService.getShopDetails(body.email)
        val shop = info.dropy.dropy.Shops.commons.data.Models.shop.Shop(
            name = body.name,
            category = bodycategory,
            email = body.email
        )

        if (emailExists == null){
            shopService.registerShop(shop, bodycategory)
            return "shop created"
        }else{
            return "email already exists"
        }


    }
}
