package info.dropy.dropy.Shops.data.repositories.products

import info.dropy.dropy.Shops.data.Models.products.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Productrepo: JpaRepository<Product,Long> {
}