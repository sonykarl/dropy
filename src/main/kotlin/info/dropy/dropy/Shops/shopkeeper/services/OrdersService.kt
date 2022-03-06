package info.dropy.dropy.Shops.shopkeeper.services

import info.dropy.dropy.Shops.commons.data.Models.orders.Orders
import info.dropy.dropy.Shops.commons.data.repositories.shops.OrdersRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrdersService @Autowired constructor(
    private val repo: OrdersRepo
) {
    fun getShopOrders(id: Long): List<Orders?>?{
        return repo.findAllByShopId(id)
    }
}