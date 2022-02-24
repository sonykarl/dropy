package info.dropy.dropy.authentication.Customer.data



data class CustomerRegDto(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String?,
    val email: String,
    val authority: String? = "Customer"
)