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
//        for (shop in 0 until shops!!.size){
//            val shopDetails = shops!!.forEach {
//                    shop: Shop ->
//                val pathName = "http://localhost:9090/static/shopslogoimages/${shop.shopLogo}"
//                val shopDetail = Shop(id = shop.id,name = shop.name,email = shop.email,category = shop.category,shopLogo = pathName)
//                shopDetail
//            }
//            shopDetails
//        }

        return shops
    }

    fun getShopByCategory(categoryid: Long?): List<Shop>?{
        return shopRepo.findByCategoryId(categoryid)
    }


}