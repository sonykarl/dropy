package info.dropy.dropy.Shops.data.repositories.location

import org.springframework.data.jpa.repository.JpaRepository

interface Address: JpaRepository<Address,Long> {
}