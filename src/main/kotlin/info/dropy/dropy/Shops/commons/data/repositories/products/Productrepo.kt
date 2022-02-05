package info.dropy.dropy.Shops.commons.data.repositories.products

import info.dropy.dropy.Shops.commons.data.Models.products.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Productrepo: JpaRepository<Product,Long> {
    fun findByShopId(shopId:Long): List<Product>?
    fun findByCategoryId(categoryId: Long): List<Product>?
}