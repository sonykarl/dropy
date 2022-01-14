package info.dropy.dropy.Shops.commons.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.FileOutputStream

@RestController
@RequestMapping("api/test")
class Tester (){

    @PostMapping
    fun uploadImage(
        @RequestParam("image")multipartFile:MultipartFile
    ): String{
        if (multipartFile.isEmpty){
            return "file unavailable"
        } else{
            val imagename = multipartFile.originalFilename
            val filepath = "C:\\Users\\wuodmogo\\IdeaProjects\\dropy\\dropy\\src\\main\\resources\\static\\shopslogoimages\\"
            val byte = multipartFile.bytes
            val outputStream = FileOutputStream(filepath+imagename)
            outputStream.write(byte)
            return "file saved "
        }
    }
}