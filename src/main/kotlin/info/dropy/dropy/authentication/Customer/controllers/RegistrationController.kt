package info.dropy.dropy.authentication.Customer.controllers

import info.dropy.dropy.Customers.Service.CustomerDataServices
import info.dropy.dropy.Customers.data.models.Customer
import info.dropy.dropy.authentication.Customer.data.CustomerLogDto
import info.dropy.dropy.authentication.Customer.data.CustomerRegDto
import info.dropy.dropy.authentication.Customer.logic.CustomerAuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/customer")
class RegistrationController @Autowired constructor(
    private val authService: CustomerAuthService,
    private val customerDataServices: CustomerDataServices
    ){


    @PostMapping("register")
    fun registerCustomer(@RequestBody body: CustomerRegDto): String{
        val customer = Customer(firstName = body.firstName, lastName = body.lastName, email = body.email,
            phoneNumber = body.phoneNumber!!.toLong(), authority = body.authority)

        authService.saveCustomer(customer)
        return "customer saved"


    }

    @PutMapping("updateFirebaseId")
    fun updateFirebaseId(
        @RequestBody customer: Customer
    ){
        authService.saveCustomer(customer = customer)
    }

    @GetMapping("getCustomers")
    fun getAllCustomer(): ResponseEntity<Any>{
        val customers = customerDataServices.getAllCustomers()
        return ResponseEntity.ok()
            .body(customers)
    }
}