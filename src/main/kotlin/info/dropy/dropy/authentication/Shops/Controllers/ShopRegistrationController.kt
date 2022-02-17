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
import java.io.FileOutputStream
import java.nio.file.Files
import java.nio.file.Paths

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
        @RequestParam("shopslogo") shopsLogo: MultipartFile,
        @RequestParam("shopsHeader") shopsHeader: MultipartFile
    ): String{

        val bodycategory = categoryDetailsService.getRetailCategory(body.category)?: RetailCategory(
            name = body.category
        )
        val shoplogo = shopsLogo.originalFilename
        val shopsHeader = shopsHeader.originalFilename
        val emailExists = shopDetailsService.getShopDetailsByEmail(body.email)
        val shop = Shop(
            name = body.name,
            category = bodycategory,
            email = body.email,
            shopLogo = shoplogo,
            shopHeader = shopsHeader,
            shopbranch = body.branch,
            shopLocation = body.shopLocation,
            phoneNumber = body.phoneNumber
        )
        if (emailExists != null && shopsLogo.isEmpty){
            return "email already exists"
        }else{
            val filePath = "C:\\Users\\wuodmogo\\IdeaProjects\\dropy\\dropy\\src\\main\\resources\\static\\shopslogoimages\\"
            val bytes = shopsLogo.bytes
            val outputStream = FileOutputStream(filePath+shoplogo)
            outputStream.write(bytes)
            shopService.registerShop(shop, bodycategory)
            return "shop created"
        }


    }
}
