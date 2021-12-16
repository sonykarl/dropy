package info.dropy.dropy.authentication.Customer.data


data class CustomerRegDto(
    val firstName: String,
    val lastName: String,
    val phoneNumber: Long,
    val email: String,
    val password: String
)