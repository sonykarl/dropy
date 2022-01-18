package info.dropy.dropy.Shops.commons.data.dtos

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.core.io.InputStreamResource

@JsonIgnoreProperties(ignoreUnknown = true)
data class ShopDetailsDto (
    val imageSrc : String,
    val shopName : String
        )