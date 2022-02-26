package info.dropy.dropy.authentication.Shops.dtos

import info.dropy.dropy.Shops.commons.data.Models.shop.ShopBranch



data class Shopdto (
    val name: String,
    val category: String,
    val email: String,
    val branch: List<ShopBranch>? = null,
    val shopLatitude: Double? = null,
    val shopLongitude: Double? = null,
    val phoneNumber: Long,
    val firebaseId: String?
        )