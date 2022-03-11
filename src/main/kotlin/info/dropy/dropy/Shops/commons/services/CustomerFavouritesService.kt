package info.dropy.dropy.Shops.commons.services

import info.dropy.dropy.Shops.commons.data.Models.shop.CustomerFavourites
import info.dropy.dropy.Shops.commons.data.repositories.shops.CustomerFavouritesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerFavouritesService @Autowired constructor(
    private val customerFavouritesrepo: CustomerFavouritesRepository
){
    fun findCustomerFavourites(customer: Long): List<CustomerFavourites?>{
        return customerFavouritesrepo.findByCustomer(customer = customer)
    }

    fun findAllShopsFavourites(id: Long): List<CustomerFavourites?>{
        return customerFavouritesrepo.findByShop(shopId = id)
    }

    fun findAllFavourites(): List<CustomerFavourites>{
        return customerFavouritesrepo.findAll()
    }

    fun saveCustomerFavourites(customerFavourites: CustomerFavourites){
         customerFavouritesrepo.save(customerFavourites)
    }
}