package info.dropy.dropy.configurations


import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.lang.reflect.Array.get
import java.nio.file.Path
import java.nio.file.Paths.get

@EnableWebMvc
@Configuration
class WebSecurityConfig: WebMvcConfigurer{

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry
            .addResourceHandler("/static/**")
            .addResourceLocations("classpath:/static/")
    }

}