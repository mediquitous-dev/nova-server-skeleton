package jp.nova.domain.product.dao

import jp.nova.domain.product.entity.Product
import jp.nova.repository.product.ProductRepository

class ProductCommandDao(
    val productRepository: ProductRepository,
) {
    fun insert(product: Product): Product = productRepository.insert(product)

    fun deleteById(id: Long) = productRepository.deleteById(id)

    fun update(product: Product): Product = productRepository.insert(product)
}
