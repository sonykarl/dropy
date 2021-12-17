package info.dropy.dropy.authentication.Customer.controllers

import info.dropy.dropy.Customers.data.models.Customer
import info.dropy.dropy.authentication.Customer.data.CustomerLogDto
import info.dropy.dropy.authentication.Customer.data.CustomerRegDto
import info.dropy.dropy.authentication.Customer.logic.CustomerAuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/customer")
class RegistrationController @Autowired constructor(private val authService: CustomerAuthService, private val passwordEncoder: BCryptPasswordEncoder){


    @PostMapping("register")
    fun registerCustomer(@RequestBody body: CustomerRegDto){
        val customer = Customer(firstName = body.firstName, lastName = body.lastName, email = body.email,
            phoneNumber = body.phoneNumber, password = passwordEncoder.encode(body.password), authority = body.authority)
        authService.saveCustomer(customer)
    }


    @PostMapping("login")
    fun loginCustomer(@RequestBody body: CustomerLogDto): String{
        val customerdetails = authService.loadUserByUsername(body.email)
        return if (passwordEncoder.matches(body.password,customerdetails.password)){
            return "logged in"
        }else{
            return "details invalid"
        }
    }
}