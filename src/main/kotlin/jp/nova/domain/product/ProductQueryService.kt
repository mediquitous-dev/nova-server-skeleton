package jp.nova.domain.product

import jp.nova.domain.product.dao.ProductQueryDao
import jp.nova.domain.product.entity.Product

// @Transactional(readOnly = true)
class ProductQueryService(
    val productQueryDao: ProductQueryDao,
) {
    fun findById(id: Long): Product = productQueryDao.findById(id)

    fun findAll(): List<Product> = productQueryDao.findAll()
}
