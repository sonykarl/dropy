package info.dropy.dropy.authentication.Shops.dtos

import info.dropy.dropy.Shops.commons.data.Models.shop.RetailCategory

data class Shopdto (
    val name: String,
    val category: String,
    val email: String,
    val logo: String
        )