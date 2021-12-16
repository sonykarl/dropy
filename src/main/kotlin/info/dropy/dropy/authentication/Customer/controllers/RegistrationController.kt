package info.dropy.dropy.authentication.Customer.controllers

import info.dropy.dropy.Customers.data.models.Customer
import info.dropy.dropy.authentication.Customer.data.CustomerRegDto
import info.dropy.dropy.authentication.Customer.logic.CustomerAuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/register")
class RegistrationController @Autowired constructor(private val authService: CustomerAuthService){
    @PostMapping("customer")
    fun registerCustomer(@RequestBody body: CustomerRegDto){
        val customer = Customer(firstName = body.firstName, lastName = body.lastName, email = body.email,
            phoneNumber = body.phoneNumber, password = body.password)
        authService.saveCustomer(customer)
    }
}