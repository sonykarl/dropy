package info.dropy.dropy.Shops.commons.services

import info.dropy.dropy.Shops.commons.data.Models.shop.RetailCategory
import info.dropy.dropy.Shops.commons.data.repositories.shops.RetailCategoryrepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryDetailsService @Autowired constructor(private val retailCategoryrepo: RetailCategoryrepo){

    fun getRetailCategory(name: String): RetailCategory?{
        return retailCategoryrepo.findByName(name)
    }
}