package info.dropy.dropy


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
//@EntityScan(basePackages = ["info.dropy.dropy.Shops.data","info.dropy.dropy.Customers.data"])
class DropyApplication

fun main(args: Array<String>) {

	runApplication<DropyApplication>(*args)
}

