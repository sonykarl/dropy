package info.dropy.dropy.Shops.commons.controllers

import info.dropy.dropy.Shops.commons.data.Models.products.Product
import info.dropy.dropy.Shops.commons.data.dtos.GetShopProductsDto
import info.dropy.dropy.Shops.commons.services.ShopDetailsService
import info.dropy.dropy.Shops.commons.services.ShopProductsService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/shops/products")
class GetProductsController constructor(private val productsService: ShopProductsService){

    @GetMapping("allproducts")
    fun getProducts(): ResponseEntity<Any>{
        val allProducts = productsService.showAllproducts()
        return ResponseEntity.ok()
            .body(allProducts)
    }

    @GetMapping("shopAllProducts/{id}")
    fun getShopProducts(@PathVariable id: String): ResponseEntity<Any>{
        val shopProducts = productsService.showShopProducts(shopId = id.toLong())
        return ResponseEntity.ok()
            .body(shopProducts)
    }

    @GetMapping("shopRelatedProducts/{id}")
    fun getShopRelatedProducts(@PathVariable id: String): ResponseEntity<Any>{
        val shopRelatedProducts = productsService.showRelatedShopProducts(categoryId = id.toLong())
        return ResponseEntity.ok()
            .body(shopRelatedProducts)
    }


}