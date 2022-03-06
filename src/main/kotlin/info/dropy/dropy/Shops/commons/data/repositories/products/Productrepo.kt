package info.dropy.dropy.Shops.commons.data.repositories.products

import info.dropy.dropy.Shops.commons.data.Models.products.Product
import info.dropy.dropy.Shops.commons.data.Models.products.ProductCategory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.persistence.NamedNativeQuery

@Repository
interface Productrepo: JpaRepository<Product,Long> {
    fun findByShopId(shopId:Long?): List<Product?>?

    fun findByCategoryId(categoryId: Long): List<Product>?

    @Query(value = "SELECT category_id FROM product", nativeQuery = true)
    fun getCategories(): List<Int>?
}