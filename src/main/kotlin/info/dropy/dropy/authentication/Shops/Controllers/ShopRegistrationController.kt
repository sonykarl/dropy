package info.dropy.dropy.authentication.Shops.Controllers

import info.dropy.dropy.Shops.commons.data.Models.shop.RetailCategory
import info.dropy.dropy.Shops.commons.data.Models.shop.Shop
import info.dropy.dropy.Shops.shopkeeper.services.AddShopService
import info.dropy.dropy.Shops.commons.services.CategoryDetailsService
import info.dropy.dropy.Shops.commons.services.ShopDetailsService
import info.dropy.dropy.authentication.Shops.dtos.Shopdto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("api/v1/shops")
class ShopRegistrationController  @Autowired constructor(
    private val shopService: AddShopService,
    private val shopDetailsService: ShopDetailsService,
    private val categoryDetailsService: CategoryDetailsService
) {

    @PostMapping("register")
    fun registerShop(
        @RequestBody body: Shopdto,
        @RequestParam("image") multipartFile: MultipartFile
    ): String{

        val bodycategory = categoryDetailsService.getRetailCategory(body.category)?: RetailCategory(
            name = body.category
        )
        val shoplogo = multipartFile.originalFilename
        val emailExists = shopDetailsService.getShopDetails(body.email)
        val shop = Shop(
            name = body.name,
            category = bodycategory,
            email = body.email,
            shopLogo = shoplogo
        )

        if (emailExists != null && multipartFile.isEmpty){
            return "email already exists"
        }else{
            shopService.registerShop(shop, bodycategory)
            return "shop created"
        }


    }
}
