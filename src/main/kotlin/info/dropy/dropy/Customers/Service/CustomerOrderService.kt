package info.dropy.dropy.Customers.Service

import info.dropy.dropy.Customers.data.orders.CustomerOrder
import info.dropy.dropy.Customers.data.repositories.CustomerOrderRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerOrderService @Autowired constructor(
    val orderrepo: CustomerOrderRepo
) {

    fun addCustomerOrder(order: CustomerOrder){

            orderrepo.save(order)
    }

    fun getAllOrders():List<CustomerOrder>{
        return orderrepo.findAll()
    }
}