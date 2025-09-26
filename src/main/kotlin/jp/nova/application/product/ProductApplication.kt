package jp.nova.application.product

import jp.nova.api.product.dto.ProductRes
import jp.nova.application.product.mapper.ProductMapper
import jp.nova.domain.product.ProductQueryService
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ProductApplication(
    private val productQueryService: ProductQueryService,
) {
    val converter = Mappers.getMapper(ProductMapper::class.java)

    // validation, aggregation
    fun findById(id: Long): ProductRes {
        val product = productQueryService.findById(id)
        val productRes = converter.toRes(product)

        return productRes
    }

    fun findAll(): List<ProductRes> {
        val products = productQueryService.findAll()
        return products
            .stream()
            .map { product -> product.let { converter.toRes(it) } }
            .collect(Collectors.toList()) as List<ProductRes>
    }
}
