package info.dropy.dropy.Customers.Service

import info.dropy.dropy.Customers.data.orders.CustomerOrder
import info.dropy.dropy.Customers.data.repositories.CustomerOrderRepo
import jdk.internal.net.http.common.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.IOException

@Service
class CustomerOrderService @Autowired constructor(
    val orderrepo: CustomerOrderRepo
) {

    fun addCustomerOrder(order: CustomerOrder){
        try {
            orderrepo.save(order)
        }catch (e:IOException){
            Log.ALL
        }
    }
}