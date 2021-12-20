package info.dropy.dropy.Shops.services

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File


@Service
class AddProductService {

    fun addProduct(file: MultipartFile){

    }
    fun uploadImage(file:MultipartFile){
        file.transferTo(File("C:\\Users\\wuodmogo\\IdeaProjects\\dropy\\dropy\\src\\main\\resources\\static\\productimages",file.originalFilename))
    }
}