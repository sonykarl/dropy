package info.dropy.dropy.authentication.Shops.Controllers

import info.dropy.dropy.Shops.commons.data.Models.shop.RetailCategory
import info.dropy.dropy.Shops.commons.data.Models.shop.Shop
import info.dropy.dropy.Shops.commons.data.Models.shop.ShopLocation
import info.dropy.dropy.Shops.shopkeeper.services.AddShopService
import info.dropy.dropy.Shops.commons.services.CategoryDetailsService
import info.dropy.dropy.Shops.commons.services.ShopDetailsService
import info.dropy.dropy.Shops.commons.services.ShopLocationService
import info.dropy.dropy.authentication.Shops.dtos.Shopdto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.nio.file.Files
import java.nio.file.Paths

@RestController
@RequestMapping("api/v1/shops")
class ShopRegistrationController  @Autowired constructor(
    private val shopService: AddShopService,
    private val shopDetailsService: ShopDetailsService,
    private val categoryDetailsService: CategoryDetailsService,
) {

    @PostMapping("register")
    fun registerShop(
        @RequestBody body: Shopdto,

    ){

        var bodycategory = categoryDetailsService.getRetailCategory(body.category)?: RetailCategory(
            name = body.category
        )

        val emailExists = shopDetailsService.getShopDetailsByEmail(body.email)
        val shop = Shop(
            name = body.name,
            category = bodycategory,
            email = body.email,
            shopbranch = body.branch,
            phoneNumber = body.phoneNumber,
            latitude = body.shopLatitude,
            longitude = body.shopLongitude,
            firebaseId = body.firebaseId
        )
        shopService.registerShop(shop,bodycategory)
//        if (emailExists != null && shopsLogo.isEmpty){
//            return "email already exists"
//        }else{

//        }


    }

    @PostMapping("uploadshopPhotos")
    fun uploadPhotos(
        @RequestParam ("shoplogo")shoplogo: MultipartFile,
        @RequestParam ("shopfeaturephoto")shopFeaturePhoto: MultipartFile
    ) :ResponseEntity<Any> {

        shoplogo.transferTo(File("C:\\Users\\wuodmogo\\IdeaProjects\\dropy\\dropy\\src\\main\\resources\\static\\shopslogoimages\\"+shoplogo.originalFilename))
        return ResponseEntity.ok()
            .body("shop created")
    }
}

