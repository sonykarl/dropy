package info.dropy.dropy.Shops.commons.services

import info.dropy.dropy.Shops.commons.data.Models.shop.Shop
import info.dropy.dropy.Shops.commons.data.repositories.shops.ShopRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShopDetailsService @Autowired constructor(private val shopRepo: ShopRepo){

    fun getShopDetails(email:String?): Shop? {
        val shop = shopRepo.findByEmail(email)
        return shop
    }

    fun getAllShops(): List<Shop>?{
        val shops =  shopRepo.findAll()
        return shops
    }

    fun getShopByCategory(categoryid: Long?): List<Shop>?{
        return shopRepo.findByCategoryId(categoryid)
    }


}