package jp.nova.domain.product.dao

import jp.nova.domain.product.entity.Product
import jp.nova.repository.product.ProductRepository

class ProductQueryDao(
    val productRepository: ProductRepository,
) {
    fun findById(id: Long): Product = productRepository.findById(id)

    fun findAll(): List<Product> = productRepository.findAll()
}
