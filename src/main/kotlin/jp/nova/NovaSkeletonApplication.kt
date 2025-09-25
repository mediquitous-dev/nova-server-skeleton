package jp.nova

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class NovaSkeletonApplication

fun main(args: Array<String>) {
	runApplication<NovaSkeletonApplication>(*args)
}
