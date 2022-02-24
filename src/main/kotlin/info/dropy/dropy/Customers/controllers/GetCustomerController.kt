package info.dropy.dropy.Customers.controllers

import info.dropy.dropy.Customers.Service.CustomerDataServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/customers")
class GetCustomerController @Autowired constructor(
    private val customerdataservices: CustomerDataServices
){
    @GetMapping("getCustomerById/{customerId}")
    fun getCustomerById(@PathVariable customerId: String):ResponseEntity<Any>{
        val customer = customerdataservices.findByCustomerId(id = customerId.toLong())
        return  ResponseEntity.ok()
            .body(customer)
    }

    @GetMapping("getCustomerByEmail/{customerEmail}")
    fun getCustomerEmail(@PathVariable customerEmail:String): ResponseEntity<Any>{
        val customer = customerdataservices.findByCustomerEmail(email = customerEmail)
        return ResponseEntity.ok()
            .body(customer)
    }

    @GetMapping("getCustomerByFirebaseId/{firebaseId}")
    fun getFirebaseId(@PathVariable firebaseId:String):ResponseEntity<Any>{
        val customer = customerdataservices.findByFirebaseId(firebaseId = firebaseId)
        return ResponseEntity.ok()
            .body(customer)
    }

    @GetMapping("getCustomerByPhoneNumber/{phoneNumber}")
    fun getPhoneNumber(@PathVariable phoneNumber:String):ResponseEntity<Any>{
        val customer = customerdataservices.findByPhoneNumber(phoneNumber = phoneNumber)
        return ResponseEntity.ok()
            .body(customer)
    }
}