package info.dropy.dropy.Shops.data.repositories.orders

import org.springframework.data.jpa.repository.JpaRepository

interface Orders: JpaRepository<Orders,Long> {
}