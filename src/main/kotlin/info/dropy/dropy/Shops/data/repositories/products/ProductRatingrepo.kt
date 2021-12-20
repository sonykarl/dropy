package info.dropy.dropy.Shops.data.repositories.products

import info.dropy.dropy.Shops.data.Models.products.ProductRating
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRatingrepo: JpaRepository<ProductRating,Long> {
}