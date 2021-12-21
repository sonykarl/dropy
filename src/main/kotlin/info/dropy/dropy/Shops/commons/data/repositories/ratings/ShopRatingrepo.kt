package info.dropy.dropy.Shops.commons.data.repositories.ratings

import info.dropy.dropy.Shops.commons.data.Models.ratings.ShopRating
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopRatingrepo: JpaRepository<ShopRating,Long> {
}