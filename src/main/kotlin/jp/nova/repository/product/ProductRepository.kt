package jp.nova.repository.product

import jp.nova.domain.product.entity.Product
import org.springframework.stereotype.Repository

@Repository
class ProductRepository {
    fun findById(id: Long): Product = Product(id, "상품명", 10000L, "상품 설명")

    fun findAll(): List<Product> =
        mutableListOf(
            Product(1L, "상품명 1", 10000L, "상품 설명"),
            Product(2L, "상품명 2", 20000L, "상품 설명"),
        )

    fun insert(product: Product): Product = findById(2L)

    fun deleteById(id: Long) {
    }

    fun update(product: Product): Product = findById(product.id!!)
}
