package info.dropy.dropy.Shops.controllers

import info.dropy.dropy.Shops.services.AddProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("api/v1/shops/addproducts")
class AddProductController @Autowired constructor(val addProductService: AddProductService){

    @PostMapping
    fun addProducts(@RequestParam("file") file: MultipartFile){
        addProductService.uploadImage(file = file)
    }
}