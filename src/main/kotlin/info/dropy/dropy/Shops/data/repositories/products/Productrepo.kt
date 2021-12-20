package info.dropy.dropy.Shops.data.repositories.products

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Productrepo: JpaRepository<Productrepo,Long> {
}