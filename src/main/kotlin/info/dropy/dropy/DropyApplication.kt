package info.dropy.dropy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DropyApplication

fun main(args: Array<String>) {
	runApplication<DropyApplication>(*args)
}
