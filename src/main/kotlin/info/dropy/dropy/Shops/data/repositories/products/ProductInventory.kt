package info.dropy.dropy.Shops.data.repositories.products

import org.springframework.data.jpa.repository.JpaRepository

interface ProductInventory: JpaRepository<ProductInventory,Long> {
}