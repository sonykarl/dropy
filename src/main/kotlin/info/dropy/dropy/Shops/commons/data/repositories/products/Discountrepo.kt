package info.dropy.dropy.Shops.commons.data.repositories.products

import info.dropy.dropy.Shops.commons.data.Models.products.Discount
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Discountrepo: JpaRepository<Discount,Long> {
}