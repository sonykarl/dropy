package info.dropy.dropy.Shops.commons.data.repositories.shops

import info.dropy.dropy.Shops.commons.data.Models.shop.Shop
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ShopRepo: JpaRepository<Shop,Long> {
    @Query("SELECT * FROM shop WHERE firebase_id = :firebase_id", nativeQuery = true)
    fun findByFirebaseId(
        @Param("firebase_id") firebase_id: String?): Shop?
    fun findByCategoryId(category: Long?): List<Shop>?
    fun findById(id: Long?): Shop?
}