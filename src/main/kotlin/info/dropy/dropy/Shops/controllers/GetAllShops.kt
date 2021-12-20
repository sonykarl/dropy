package info.dropy.dropy.Shops.controllers

import info.dropy.dropy.Shops.data.Models.shop.Shop
import info.dropy.dropy.Shops.data.dtos.GetShopByCategoryDto
import info.dropy.dropy.Shops.services.ShopDetailsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/shops")
class GetAllShops constructor(private val shopDetailsService: ShopDetailsService){

    @GetMapping("allshops")
    fun getallShops(): List<Shop>?{
        return shopDetailsService.getAllShops()
    }

    @GetMapping("shopbycategory")
    fun getShopByCategory(@RequestBody body: GetShopByCategoryDto): List<Shop>?{
        return shopDetailsService.getShopByCategory(body.category_id)
    }
}