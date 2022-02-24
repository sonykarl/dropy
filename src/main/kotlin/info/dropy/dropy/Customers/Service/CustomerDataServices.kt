package info.dropy.dropy.Customers.Service

import info.dropy.dropy.Customers.data.models.Customer
import info.dropy.dropy.Customers.data.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerDataServices @Autowired constructor(
    private val customerRepository: CustomerRepository
){

    fun updateFirebaseId(customer: Customer){
        customerRepository.save(customer)
    }

    fun findByCustomerId(id: Long): Customer?{
        return customerRepository.findById(id = id)
    }

    fun findByCustomerEmail(email:String?):Customer?{
        return  customerRepository.findByEmail(email = email)
    }

    fun findByFirebaseId(firebaseId: String):Customer?{
        return customerRepository.findByFirebaseId(id = firebaseId)
    }

    fun findByPhoneNumber(phoneNumber:String):Customer?{
        return customerRepository.findByPhoneNumber(phoneNumber = phoneNumber)
    }
    //only for testing
    fun getAllCustomers(): List<Customer?>{
        return customerRepository.findAll()
    }
}