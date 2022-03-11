package info.dropy.dropy.Shops.commons.controllers

import info.dropy.dropy.Shops.commons.data.Models.shop.CustomerFavourites
import info.dropy.dropy.Shops.commons.data.dtos.CustomerFavouritesDto
import info.dropy.dropy.Shops.commons.services.CustomerFavouritesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/shops/favourites")
class CustomerFavouritesController @Autowired constructor(
    private val customerFavouritesService: CustomerFavouritesService
){


    @GetMapping("shopfavourites/{id}")
    fun findShopFavourites(
        @PathVariable id: Long
    ): ResponseEntity<Any>{
        val shopFavourites = customerFavouritesService.findAllShopsFavourites(id = id)
        return  ResponseEntity.ok()
            .body(shopFavourites)
    }

    @GetMapping("customerFavourites/{customerId}")
    fun findCustomerFavourites(
        @PathVariable customerId: Long
    ):ResponseEntity<Any>{
        val customerFavourites = customerFavouritesService.findCustomerFavourites(customer = customerId)
        return ResponseEntity.ok()
            .body(customerFavourites)
    }


    @PostMapping("addfavourites")
    fun addCustomerFavourites(
        @RequestBody body:CustomerFavouritesDto
    ){
        val favourite = CustomerFavourites(
            customer = body.customer,
            shop = body.shop
        )
        customerFavouritesService.saveCustomerFavourites(customerFavourites = favourite)
    }

}