package info.dropy.dropy.Shops.data.Models.ratings

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopRatingrepo: JpaRepository<ShopRatingrepo,Long> {
}