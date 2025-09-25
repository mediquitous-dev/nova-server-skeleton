package jp.nova.api.product

import io.github.oshai.kotlinlogging.KotlinLogging
import jp.nova.api.product.dto.ProductReq
import jp.nova.api.product.dto.ProductRes
import jp.nova.application.product.ProductApplication
import org.springframework.web.bind.annotation.*

// @RestControllerAdvice 구현 필요
@RestController
@RequestMapping("/v1/products")
class ProductController(
	val productApplication: ProductApplication,
) {
	// https://velog.io/@glencode/kotlin-logging%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC-%ED%9A%A8%EA%B3%BC%EC%A0%81%EC%9C%BC%EB%A1%9C-%EB%A1%9C%EA%B9%85%ED%95%98%EA%B8%B0
	private val logger = KotlinLogging.logger {}

	@GetMapping("/{id}")
	fun findById(
		@PathVariable id: Long,
	): ProductRes {
		logger.info { "Product found : $id" }
		return productApplication.findById(id)
	}

	@GetMapping
	fun findAll(): List<ProductRes> {
		logger.info { "all of products" }
		val products = mutableListOf<ProductRes>()

		for (i in 1..10) {
			val id = i.toLong()
			products.add(ProductRes.of(id, "상품 순서 " + i, 10000 * id))
		}

		return products
	}

	@PostMapping
	fun create(
		@RequestBody product: ProductReq,
	): ProductRes = ProductRes(20L, product.productName!!, product.price, product.description)

	@DeleteMapping("/{id}")
	fun delete(
		@PathVariable id: Long,
	) {
		logger.info { "상품삭제 id : $id" }
	}

	@PutMapping("/{id}")
	fun update(
		@PathVariable id: Long,
		@RequestBody product: ProductReq,
	): ProductRes = ProductRes(id, product.productName!!, product.price, product.description)
}
