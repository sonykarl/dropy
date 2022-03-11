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

    @GetMapping("customerfavourites/{id)")
    fun findCustomerFavourites(
        @PathVariable id:Long
    ): ResponseEntity<Any>{
        val customerFavourites = customerFavouritesService.findCustomerFavourites(id = id)
        return ResponseEntity.ok()
            .body(customerFavourites)
    }

    @GetMapping("shopfavourites/{id}")
    fun findShopFavourites(
        @PathVariable id: Long
    ): ResponseEntity<Any>{
        val shopFavourites = customerFavouritesService.findAllShopsFavourites(id = id)
        return  ResponseEntity.ok()
            .body(shopFavourites)
    }

    @GetMapping("customerfavourites/all")
    fun findAllfavourites(): ResponseEntity<Any>{
        val favourites = customerFavouritesService.findAllFavourites()
        return ResponseEntity.ok()
            .body(favourites)
    }

    @PostMapping("addfavourites")
    fun addCustomerFavourites(
        @RequestBody body:CustomerFavouritesDto
    ):ResponseEntity<Any>{
        val favourite = CustomerFavourites(
            customer = body.customer,
            shop = body.shop
        )
        return  ResponseEntity.ok()
            .body(favourite)
    }

}