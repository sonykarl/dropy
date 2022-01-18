package info.dropy.dropy.Shops.commons.data.dtos

import org.springframework.core.io.InputStreamResource

data class ShopDetailsDto (
    val imageSrc : InputStreamResource,
    val shopName : String
        )