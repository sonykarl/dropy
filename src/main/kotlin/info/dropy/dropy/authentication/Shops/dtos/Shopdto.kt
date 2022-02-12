package info.dropy.dropy.authentication.Shops.dtos

import info.dropy.dropy.Shops.commons.data.Models.shop.ShopBranch
import info.dropy.dropy.Shops.commons.data.Models.shop.ShopLocation


data class Shopdto (
    val name: String,
    val category: String,
    val email: String,
    val branch: List<ShopBranch>? = null,
    val shopLocation: ShopLocation
        )