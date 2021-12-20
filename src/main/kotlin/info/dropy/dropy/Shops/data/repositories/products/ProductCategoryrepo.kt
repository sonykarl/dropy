package info.dropy.dropy.Shops.data.repositories.products

import info.dropy.dropy.Shops.data.Models.products.ProductCategory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductCategoryrepo: JpaRepository<ProductCategory,Long> {
}