package info.dropy.dropy.Shops.services

import info.dropy.dropy.Shops.data.Models.shop.Shop
import info.dropy.dropy.Shops.data.repositories.shop.ShopRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShopDetailsService @Autowired constructor(private val shopRepo: ShopRepo){
    fun getShopDetails(email:String?): Shop? {
        val shop = shopRepo.findByEmail(email)
        return shop
    }

    fun getAllShops(): List<Shop>?{
        return shopRepo.findAll()
    }

    fun getShopByCategory(categoryid: Long?): List<Shop>?{
        return shopRepo.findByCategoryId(categoryid)
    }
}