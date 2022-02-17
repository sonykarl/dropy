package info.dropy.dropy.Shops.commons.services

import info.dropy.dropy.Shops.commons.data.Models.shop.CustomerFavourites
import info.dropy.dropy.Shops.commons.data.repositories.shops.CustomerFavouritesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerFavouritesService @Autowired constructor(
    private val customerFavouritesrepo: CustomerFavouritesRepository
){
    fun findCustomerFavourites(id: Long): List<CustomerFavourites>{
        return customerFavouritesrepo.findByCustomerId(customerId = id)
    }

    fun findAllShopsFavourites(id: Long): List<CustomerFavourites>{
        return customerFavouritesrepo.findByShopId(shopId = id)
    }
}