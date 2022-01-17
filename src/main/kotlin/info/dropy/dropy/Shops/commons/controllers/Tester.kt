package info.dropy.dropy.Shops.commons.controllers

import org.springframework.core.io.ClassPathResource
import org.springframework.util.StreamUtils
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.FileOutputStream
import javax.servlet.http.HttpServletResponse

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

    @GetMapping("imageupload")
    fun getImage(response: HttpServletResponse){
        val filepath = "C:\\Users\\wuodmogo\\IdeaProjects\\dropy\\dropy\\src\\main\\resources\\static\\shopslogoimages\\label.PNG"
        var imgFile = ClassPathResource(filepath)
        response.contentType
        StreamUtils.copy(imgFile.inputStream, response.outputStream)
    }
}