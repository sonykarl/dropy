package info.dropy.dropy.authentication.Customer.logic

import info.dropy.dropy.Customers.data.models.Customer
import info.dropy.dropy.Customers.data.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomerAuthService @Autowired constructor(private val repository: CustomerRepository): UserDetailsService{

    fun saveCustomer(customer: Customer){
        repository.save(customer)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val customer = repository.findByEmail(username)
        val customerPrincipal = CustomerPrincipal(customer)
        return customerPrincipal
    }

}