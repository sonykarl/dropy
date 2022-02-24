package info.dropy.dropy.Shops.commons.services

import info.dropy.dropy.Shops.commons.data.Models.shop.ShopLocation
import info.dropy.dropy.Shops.commons.data.repositories.shops.ShopLocationRepo
import org.springframework.beans.factory.annotation.Autowired

class ShopLocationService @Autowired constructor(
    private val shopLocationRepo: ShopLocationRepo
) {

    fun addShopLocation(shopLocation: ShopLocation){
        shopLocationRepo.save(shopLocation)
    }
}