package info.dropy.dropy.Shops.data.repositories.shop

import info.dropy.dropy.Shops.data.Models.shop.Shop
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopRepo: JpaRepository<Shop,Long> {
}