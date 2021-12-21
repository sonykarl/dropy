package info.dropy.dropy.Shops.services

import info.dropy.dropy.Shops.data.Models.products.Product
import info.dropy.dropy.Shops.data.repositories.products.Productrepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File


@Service
class AddProductService @Autowired constructor(private val productrepo: Productrepo){

    fun addProduct(product: Product){
//        val picturename = file.originalFilename
//        file.transferTo(File("C:\\Users\\wuodmogo\\IdeaProjects\\dropy\\dropy\\src\\main\\resources\\static\\productimages",file.originalFilename))
        productrepo.save(product)
    }

}