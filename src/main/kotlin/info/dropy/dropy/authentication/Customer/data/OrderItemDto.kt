package info.dropy.dropy.authentication.Customer.data


data class OrderItemDto (
    val quantity: Int,
    val product: Long,
    val shop: Long,
    val customer: Long
        )