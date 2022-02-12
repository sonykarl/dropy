package info.dropy.dropy.Shops.commons.data.repositories.products

import info.dropy.dropy.Shops.commons.data.Models.products.ProductCategory
import info.dropy.dropy.Shops.commons.data.Models.shop.Shop
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductCategoryrepo: JpaRepository<ProductCategory,Long> {
}