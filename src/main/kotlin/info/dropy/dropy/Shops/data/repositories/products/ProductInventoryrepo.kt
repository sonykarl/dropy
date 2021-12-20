package info.dropy.dropy.Shops.data.repositories.products

import info.dropy.dropy.Shops.data.Models.products.ProductInventory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductInventoryrepo: JpaRepository<ProductInventory,Long> {
}