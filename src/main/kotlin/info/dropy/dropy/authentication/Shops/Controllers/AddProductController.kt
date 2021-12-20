package info.dropy.dropy.authentication.Shops.Controllers

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/addproduct")
class AddProductController {
    @PostMapping
    fun addProduct(){}
}