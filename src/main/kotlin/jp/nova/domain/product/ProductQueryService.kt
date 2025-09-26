package jp.nova.domain.product

import jp.nova.domain.product.dao.ProductQueryDao
import jp.nova.domain.product.entity.Product
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class ProductQueryService(
    val productQueryDao: ProductQueryDao,
) {
    fun findById(id: Long): Product = productQueryDao.findById(id)

    fun findAll(): List<Product> = productQueryDao.findAll()
}
