package info.dropy.dropy.configurations


import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.lang.reflect.Array.get
import java.nio.file.Path
import java.nio.file.Paths.get

class WebSecurityConfig: WebMvcConfigurer{
    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        exposeDirectory("shopsPhoto", registry)
    }

    fun exposeDirectory(dirName: String, registry: ResourceHandlerRegistry){
        var uploadDir: Path = get(dirName)
        var uploadPath = uploadDir.toFile().absolutePath
        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/" + uploadPath + "/")
    }
}