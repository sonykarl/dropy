package info.dropy.dropy.authentication.Customer.data


data class OrderItemDto (
    val id: Long = 0,
    val quantity: Int,
    val product: Int,
    val shop: Int,
    val customer: Int
        )