package info.dropy.dropy.Shops.commons.services

import info.dropy.dropy.Shops.commons.data.Models.shop.Shop
import info.dropy.dropy.Shops.commons.data.repositories.shops.ShopRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShopDetailsService @Autowired constructor(private val shopRepo: ShopRepo){

    fun getShopDetails(id: Long?): Shop? {
        val shop = shopRepo.findById(id)
        return shop
    }

    fun getShopDetailsByFirebaseId(firebase_id: String?): Shop?{
        val shop = shopRepo.findByFirebaseId(firebase_id = firebase_id)

        return shop
    }
    fun getAllShops(): List<Shop>?{
        val shops =  shopRepo.findAll()
        return shops
    }
//    fun getPopularShops(): List<Shop>?{
//        val popularShops = shopRepo.
//    }

    fun getShopByCategory(categoryid: Long?): List<Shop>?{
        return shopRepo.findByCategoryId(categoryid)
    }


}