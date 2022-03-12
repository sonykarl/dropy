package info.dropy.dropy.Shops.shopkeeper.services

import info.dropy.dropy.Shops.commons.data.Models.orders.Orders
import info.dropy.dropy.Shops.commons.data.repositories.shops.OrdersRepo
import info.dropy.dropy.Shops.commons.services.ShopDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrdersService @Autowired constructor(
    private val repo: OrdersRepo,
    private val shopDetailsService: ShopDetailsService
) {
    fun getShopOrders(id: Long): List<Orders?>?{
        return repo.findAllByShop(id)
    }

    fun getShopOrderByStatus(status:String,firebaseId:String?): List<Orders?>? {
        val myShop = shopDetailsService.getShopDetailsByFirebaseId(firebase_id = firebaseId)
        val ordersByStatus = myShop?.let { repo.findByStatusAndShopId(status = status, shopId = it.id) }
        return ordersByStatus
    }

}