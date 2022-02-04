package info.dropy.dropy.Shops.commons.controllers

import info.dropy.dropy.Shops.commons.data.Models.products.Product
import info.dropy.dropy.Shops.commons.data.dtos.GetShopProductsDto
import info.dropy.dropy.Shops.commons.services.ShopDetailsService
import info.dropy.dropy.Shops.commons.services.ShopProductsService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/shops/")
class GetProductsController constructor(private val productsService: ShopProductsService, private val shopDetailsService: ShopDetailsService){

    @GetMapping("allproducts")
    fun getProducts(){
        productsService.showAllproducts()
    }

    @GetMapping("shopproducts")
    fun getShopProducts(@RequestHeader body: GetShopProductsDto): List<Product>? {
        return productsService.showShopProducts(body.shop_id)
    }

}