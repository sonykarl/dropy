package info.dropy.dropy.Shops.data.repositories.shop

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopRepo: JpaRepository<ShopRepo,Long> {
}