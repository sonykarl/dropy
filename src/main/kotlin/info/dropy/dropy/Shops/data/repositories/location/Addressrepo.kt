package info.dropy.dropy.Shops.data.repositories.location

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Addressrepo: JpaRepository<Addressrepo,Long> {
}