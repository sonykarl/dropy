package info.dropy.dropy.Shops.data.repositories.ratings

import info.dropy.dropy.Shops.data.Models.ratings.ShopRating
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopRatingrepo: JpaRepository<ShopRating,Long> {
}