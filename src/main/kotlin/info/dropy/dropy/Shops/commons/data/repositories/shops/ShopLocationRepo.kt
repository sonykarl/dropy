package info.dropy.dropy.Shops.commons.data.repositories.shops

import info.dropy.dropy.Shops.commons.data.Models.shop.ShopLocation
import org.springframework.data.jpa.repository.JpaRepository

interface ShopLocationRepo: JpaRepository<ShopLocation, Long> {
}