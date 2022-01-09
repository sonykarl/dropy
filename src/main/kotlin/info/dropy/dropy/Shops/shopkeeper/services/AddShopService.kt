package info.dropy.dropy.Shops.shopkeeper.services

import info.dropy.dropy.Shops.commons.data.Models.shop.RetailCategory
import info.dropy.dropy.Shops.commons.data.Models.shop.Shop
import info.dropy.dropy.Shops.commons.data.repositories.shops.RetailCategoryrepo
import info.dropy.dropy.Shops.commons.data.repositories.shops.ShopRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AddShopService @Autowired constructor(private val shoprepo: ShopRepo, private val categoryrepo: RetailCategoryrepo){

    fun registerShop(shop: Shop, category: RetailCategory){
        categoryrepo.save(category)
        shoprepo.save(shop)
    }
}
