package info.dropy.dropy.Shops.commons.services

import info.dropy.dropy.Shops.commons.data.Models.products.Product
import info.dropy.dropy.Shops.commons.data.Models.products.ProductCategory
import info.dropy.dropy.Shops.commons.data.repositories.products.ProductCategoryrepo
import info.dropy.dropy.Shops.commons.data.repositories.products.Productrepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.Id

@Service
class ShopProductsService @Autowired constructor(private val productrepo: Productrepo, private val productCategoryrepo: ProductCategoryrepo){

    fun showAllproducts(): List<Product>{
        return productrepo.findAll()
    }

    fun showShopProducts(shopId: Long):List<Product>?{
        return  productrepo.findByShopId(shopId)
    }

    fun showRelatedShopProducts(categoryId: Long): List<Product>?{
        return productrepo.findByCategoryId(categoryId)
    }

    fun shopProductCategories():List<Int>?{
        return productrepo.getCategories()
    }

//    fun productCategoryById(id: Long): List<ProductCategory>?{
//        return productCategoryrepo.findById(id = Long)
//    }
}