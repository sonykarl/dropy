package info.dropy.dropy.Shops.commons.services

import info.dropy.dropy.Shops.commons.data.Models.products.Product
import info.dropy.dropy.Shops.commons.data.repositories.products.Productrepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShopProductsService @Autowired constructor(private val productrepo: Productrepo){

    fun showAllproducts(): List<Product>{
        return productrepo.findAll()
    }

    fun showShopProducts(shopId: Long):List<Product>?{
        return  productrepo.findByShopId(shopId)
    }
}