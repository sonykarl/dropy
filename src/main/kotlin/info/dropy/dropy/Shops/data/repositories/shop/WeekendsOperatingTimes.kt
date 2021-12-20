package info.dropy.dropy.Shops.data.repositories.shop

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface WeekendsOperatingTimes: CrudRepository<WeekendsOperatingTimes,Long> {
}