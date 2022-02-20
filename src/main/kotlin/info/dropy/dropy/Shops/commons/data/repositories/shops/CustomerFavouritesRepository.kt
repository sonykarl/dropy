package info.dropy.dropy.Shops.commons.data.repositories.shops

import info.dropy.dropy.Shops.commons.data.Models.shop.CustomerFavourites
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerFavouritesRepository: JpaRepository<CustomerFavourites, Long> {
    fun findByCustomerId(customerId: Long): List<CustomerFavourites>?
    fun findByShopsId(shopId: Long): List<CustomerFavourites>?
}