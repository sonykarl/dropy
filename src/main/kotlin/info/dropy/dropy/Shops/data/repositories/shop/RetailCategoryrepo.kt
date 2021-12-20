package info.dropy.dropy.Shops.data.repositories.shop

import info.dropy.dropy.Shops.data.Models.shop.RetailCategory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RetailCategoryrepo: JpaRepository<RetailCategory,Long> {
    fun findByName(category_name:String):RetailCategory?
}